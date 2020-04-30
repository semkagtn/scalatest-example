package com.semkagtn.offer

import com.semkagtn.TestBase
import com.semkagtn.offer.item.Item

trait OfferDaoTest
  extends TestBase {

  def offerDao: OfferDao
  
  private var lastOfferId: Int = 0
  
  private def newOffer(): Offer = {
    lastOfferId += 1
    Offer(lastOfferId.toString, "title", BigDecimal(1.0), Item.Car("mark", "model"))
  }

  describe("get") {
    
    it("return exiistent value") {
      val offer = newOffer()
      offerDao.put(offer)
      val actualResult = offerDao.get(offer.id)
      val expectedResult = Some(offer)
      actualResult shouldBe expectedResult
    }
    
    it("return nonexistent value") {
      val offerId = "nonexistentId"
      val actualResult = offerDao.get(offerId)
      val expectedResult = None
      actualResult shouldBe expectedResult
    }
  }
  
  describe("put") {
    
    it("update value") {
      val offer = newOffer()
      val updatedOffer = offer.copy(title = offer.title + "1")
      offerDao.put(offer)
      offerDao.put(updatedOffer)
      val actualResult = offerDao.get(offer.id)
      actualResult shouldBe Some(updatedOffer)
    }
  }
  
  describe("delete") {
    
    it("delete existent") {
      new SoftAssert {
        val offer = newOffer()
        offerDao.put(offer)
        val actualReturned = offerDao.delete(offer.id)
        assertThat(actualReturned, equalTo(true))
        val actualResult = offerDao.get(offer.id)
        val expectedResult: Option[Offer] = None
        assertThat(actualResult, equalTo(expectedResult))
      }.assertAll()
    }
    
    it("delete nonexistent") {
      // TODO check return
      val offerId = "nonexistentId2"
      offerDao.delete(offerId)
    }
  }
}
