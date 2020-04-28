package com.semkagtn.offer

trait OfferDao {

  /**
   * Returns an offer with specified id if it exists.
   *
   * @return ''Some(offer)'' if exists, else ''None''.
   */
  def get(id: OfferId): Option[Offer]

  /**
   * Puts specified offer to the storage.
   * Replaces a offer if it already exists.
   */
  def put(offer: Offer): Unit

  /**
   * Deletes an offer with specified id from the storage.
   */
  def delete(id: OfferId): Unit
}
