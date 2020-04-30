package com.semkagtn.offer

import com.semkagtn.{Generators, TestBase}
import com.semkagtn.extensions.PropertyBaseSupport
import com.semkagtn.offer.item.ItemView
import org.scalactic.anyvals.PosInt

class ItemViewTest
  extends TestBase 
    with PropertyBaseSupport {

  
  propertyCheck(Generators.item, PosInt(1000)) { item =>
    val actualResult = ItemView.asView(item).asModel
    val expectedResult = Right(item)
    actualResult shouldBe expectedResult
  }
}
