package store.model.items

class Item (val item_description: String , var baseprice: Double){

  // TODO: Complete this class according to the features listed in the HW document

  def description(): String = {
    this.item_description
  }

  def setBasePrice(new_base: Double): Unit = {
    this.baseprice = new_base
  }

  def price(): Double = {
    this.baseprice
  }


}
