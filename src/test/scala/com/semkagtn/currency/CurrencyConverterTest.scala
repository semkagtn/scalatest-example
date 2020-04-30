package com.semkagtn.currency

import com.semkagtn.TestBase
import com.semkagtn.currency.Currency.Currency

class CurrencyConverterTest
  extends TestBase {

  private val converter = new CurrencyConverterImpl
  
  case class P(value: BigDecimal,
               from: Currency,
               to: Currency,
               expected: BigDecimal)
  
  val parameters: Seq[(String, P)] =
    for {
      from <- Currency.values.toSeq
      to <- Currency.values.toSeq
      if from.id < to.id
      value <- Seq(0.0, 1.0, 10.5, 100.9)
      name = s"$value$from -> $to -> $value$from"
    } yield name -> P(value, from, to, value)
  
  parameterized(parameters) { case P(value, from, to, expected) =>
    val actual = converter.convert(
      converter.convert(value, from, to),
      to,
      from
    )
    actual shouldBe expected
  }
}
