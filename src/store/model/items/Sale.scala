package store.model.items

class Sale(percent_sale : Double) extends Modifier() {



  override def updatePrice(price_before_sale : Double): Double ={
    price_before_sale * (1-(percent_sale/100))

  }

  override def computeTax(price_of_item: Double): Double = {
    0.0
  }


}
