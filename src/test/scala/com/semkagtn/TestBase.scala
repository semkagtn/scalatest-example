package com.semkagtn

import com.semkagtn.extensions.{MatcherSupport, ParameterizedSupport, SoftAssertSupport}
import org.scalatest.BeforeAndAfter
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

trait TestBase
  extends AnyFunSpec
    with BeforeAndAfter
    with Matchers
    with MatcherSupport
    with SoftAssertSupport
    with ParameterizedSupport
