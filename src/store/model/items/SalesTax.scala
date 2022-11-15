package store.model.items

class SalesTax(percent_tax:Double) extends Modifier() {

  override def updatePrice(price_before_sale: Double): Double = {
    price_before_sale

  }

  override def computeTax(price_of_item: Double): Double = {
    price_of_item * ((percent_tax/100))
  }
}







