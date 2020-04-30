package com.semkagtn.math

import com.semkagtn.TestBase

class MathUtilTest extends TestBase {

  case class P(base: Int, exponent: Int, expectedResult: Double)

  val params: Seq[(String, P)] = Seq(
    "zero to zero" -> P(0, 0, Double.NaN),
    "zero to positive" -> P(0, 22, 0.0),
    "zero to negative" -> P(0, -1, Double.PositiveInfinity),
    "positive to zero" -> P(2, 0, 1.0),
    "negative to zero" -> P(-2, 0, 1.0),
    "negative to odd" -> P(-2, 3, -8.0),
    "negative to even" -> P(-2, 2, 4.0),
    "positive to even" -> P(3, 4, 81.0),
    "positive to odd" -> P(4, 3, 64.0),
    "positive to negative" -> P(2, -1, 0.5),
    "negative to negative" -> P(-2, -1, -0.5)
  )

  parameterized(params) { case P(base, e, res) =>
    val actual = MathUtil.pow(base, e)
    actual should approxEqual(res)
  }
}
