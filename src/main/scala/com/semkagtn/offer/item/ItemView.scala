package com.semkagtn.offer.item


case class ItemView(mark: Option[String] = None,
                    model: Option[String] = None,
                    rooms: Option[Int] = None,
                    floor: Option[Int] = None) {
  
  def asModel: Either[IllegalArgumentException, Item] =
    (mark, model, rooms, floor) match {
      case (Some(mark), Some(model), None, None) =>
        Right(Item.Car(mark, model))
      case (None, None, Some(rooms), Some(floor)) =>
        Right(Item.Flat(rooms, floor))
      case _ =>
        Left(new IllegalArgumentException(s"Invalid item view: $this"))
    }
}

object ItemView {
  
  def asView(model: Item): ItemView = model match {
    case Item.Car(mark, model) =>
      ItemView(
        mark = Some(mark),
        model = Some(model)
      )
    case Item.Flat(rooms, floor) =>
      ItemView(
        rooms = Some(rooms),
        floor = Some(floor)
      )
  }
}
