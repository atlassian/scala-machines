package com.clarifi.machines

import scalaz._
import Plan._

/**
 *
 */

object Process {
  import Machine.ProcessCategory._

  def prepended[F[_], A](as: F[A])(implicit F: Foldable[F]): Process[A, A] =
    traversePlan_(as)(emit) >> id

  def filtered[A](p: A => Boolean): Process[A, A] =
    (for {
      i <- await[A]
      _ <- if (p(i)) emit(i) else Return(())
    } yield ()) repeatedly

  def dropping[A](n: Int): Process[A, A] =
    await[A].replicateM_(n) >> id

  def taking[A](n: Int): Process[A, A] =
    (await[A] flatMap emit).replicateM_(n).compile

  def takingWhile[A](p: A => Boolean): Process[A, A] =
    await[A] flatMap (v => if (p(v)) emit(v) else Stop) repeatedly

  def droppingWhile[A](p: A => Boolean): Process[A, A] = {
    lazy val loop: Plan[A => Any, A, Unit] = await[A] flatMap (v => if (p(v)) loop else emit(v))
    loop >> id
  }

  def buffered[A](n: Int): Process[A, List[A]] = {
    def go(xs: List[A], c: Int): Plan[A => Any, List[A], Unit] = (xs, c) match {
      case (List(), 0) => Stop
      case (acc, 0) => emit(acc reverse)
      case (acc, n) => for {
        i <- await[A] orElse (emit(acc reverse) >> Stop)
        _ <- go(i :: acc, n - 1)
      } yield ()
    }
    go(List(), n) repeatedly
  }

  def grouping[A](p: (A, A) => Boolean): Process[A, List[A]] = {
    def collect(acc: List[A], x: A): Process[A, List[A]] =
      await[A] orElse (emit(acc reverse) >> Stop) flatMap { y =>
        if (p(x, y)) collect(y::acc, x)
        else emit(acc reverse) >> collect(List(), y)
      }
    await[A] flatMap (collect(List(), _))
  }
}
