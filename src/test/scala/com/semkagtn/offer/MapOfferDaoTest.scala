package com.semkagtn.offer

class MapOfferDaoTest
  extends OfferDaoTest {
  
  override val offerDao: OfferDao = new MapOfferDao
}
