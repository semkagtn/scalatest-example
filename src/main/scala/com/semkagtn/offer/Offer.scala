package com.semkagtn.offer

import com.semkagtn.offer.item.Item

final case class Offer(id: OfferId,
                       title: String,
                       price: BigDecimal,
                       item: Item)