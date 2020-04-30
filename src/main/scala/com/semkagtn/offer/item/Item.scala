package com.semkagtn.offer.item

sealed trait Item

object Item {
  
  final case class Car(mark: String,
                       model: String)
    extends Item
  
  final case class Flat(rooms: Int,
                        floor: Int)
    extends Item
  
  // ... other
}
