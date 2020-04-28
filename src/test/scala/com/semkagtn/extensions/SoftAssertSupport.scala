package com.semkagtn.extensions

import org.scalatest.exceptions.TestFailedException
import org.scalatest.matchers.Matcher
import org.scalatest.matchers.should.Matchers

import scala.util.control.NoStackTrace

trait SoftAssertSupport { self: Matchers => 

  private var exceptions = Seq.empty[TestFailedException]
  
  protected class SoftAssert {

    protected def assertThat[A](actual: A, expected: Matcher[A]): Unit =
      try {
        actual should expected
      } catch {
        case exception: TestFailedException => exceptions :+= exception
      }

    def assertAll(): Unit =
      if (exceptions.nonEmpty) {
        val errorMsg = exceptions.map(_.stackTrackAsString).mkString("\n")
        throw new AssertionError(errorMsg) with NoStackTrace
      }
  }
}
