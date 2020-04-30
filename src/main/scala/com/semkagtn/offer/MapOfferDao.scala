package com.semkagtn.offer

class MapOfferDao
  extends OfferDao {
  
  private var map = Map.empty[OfferId, Offer]
  
  override def get(id: OfferId): Option[Offer] =
    map.get(id)

  override def put(offer: Offer): Unit =
    map = map.updated(offer.id, offer)

  override def delete(id: OfferId): Boolean = {
    val result = !map.contains(id)
//    map = map.removed(id)
    result
  }
}
