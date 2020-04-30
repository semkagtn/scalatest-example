package com.semkagtn.extensions

import com.semkagtn.matcher.ScalatestMatcher
import org.scalatest.matchers.Matcher

trait MatcherSupport {

  // TODO generalize
  def greaterThan(value: Long): Matcher[Long] = new ScalatestMatcher[Long] {

    override protected def matches(actualResult: Long): Boolean =
      actualResult > value

    override protected def asString: String =
      s"greater than $value"
  }

  def equalTo[A](expected: A): Matcher[A] = new ScalatestMatcher[A] {
    override protected def matches(actualResult: A): Boolean =
      actualResult == expected

    override protected def asString: String =
      expected.toString
  }

  def approxEqual(expected: Double): Matcher[Double] = new ScalatestMatcher[Double] {
    override protected def matches(actualResult: Double): Boolean = Math.abs(expected - actualResult) < 1e-6

    override protected def asString: String = s"approximately equal to $expected"
  }
}
