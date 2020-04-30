package com.semkagtn

import com.semkagtn.offer.item.Item
import org.scalacheck.Gen

object Generators {
  
  val car: Gen[Item.Car] =
    for {
      mark <- Gen.alphaNumStr
      model <- Gen.alphaNumStr
    } yield Item.Car(
      mark = mark,
      model = model
    )
  
  val flat: Gen[Item.Flat] =
    for {
      rooms <- Gen.chooseNum(1, 7)
      floor <- Gen.chooseNum(1, 100)
    } yield Item.Flat(
      rooms = rooms,
      floor = floor
    )

  val item: Gen[Item] =
    Gen.oneOf(car, flat)
}
