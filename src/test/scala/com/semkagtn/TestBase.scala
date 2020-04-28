package com.semkagtn

import org.scalatest.BeforeAndAfter
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

trait TestBase
  extends AnyFunSpec
    with BeforeAndAfter
    with Matchers
