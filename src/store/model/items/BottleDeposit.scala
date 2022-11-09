package store.model.items

class BottleDeposit(total_charged:Double) extends Modifier {

  override def updatePrice(price_before_sale: Double): Double = {
    price_before_sale

  }

  override def computeTax(price_of_item: Double): Double = {
    total_charged
  }
}
