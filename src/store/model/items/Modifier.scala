package store.model.items

abstract class Modifier() {

  def updatePrice(beforeModifier : Double): Double

  def computeTax(price_of_item : Double): Double

}

