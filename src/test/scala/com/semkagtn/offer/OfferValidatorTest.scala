package com.semkagtn.offer

import com.semkagtn.offer.item.Item
import com.semkagtn.{Generators, TestBase}

class OfferValidatorTest
  extends TestBase {

  val validator = new OfferValidatorImpl
  
  private val basicOffer = Offer(
    "id",
    "title",
    1.0,
    Generators.item.sample.get
  )
  
  case class P(price: BigDecimal, 
               item: Item,
               expectedResult: Boolean)
  
  val params: Seq[(String, P)] = Seq(
    "maximum car price" -> P(1000, Generators.car.sample.get, true),
    "gereater than maximum car price" -> P(1001, Generators.car.sample.get, false),
    "min car price" -> P(100, Generators.car.sample.get, true),
    "less than min car price" -> P(99, Generators.car.sample.get, false),
  )
  // TODO flat
  
  parameterized(params) { case P(price, item, expected) =>
    val offer = basicOffer.copy(price = price, item = item)
    val actual = validator.validate(offer)
    actual shouldBe expected
  }
}
