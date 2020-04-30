package com.semkagtn.offer

import com.semkagtn.offer.item.Item

class OfferValidatorImpl
  extends OfferValidator {
  
  override def validate(offer: Offer): Boolean = offer.item match {
    case _: Item.Car => offer.price >= 100 && offer.price <= 1000
    case _: Item.Flat => offer.price <= 10000
  }
}
