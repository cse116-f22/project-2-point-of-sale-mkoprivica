package store.model.items

class Item (val item_description: String , var baseprice: Double){

  // TODO: Complete this class according to the features listed in the HW document

  var all_modifiers: List[Modifier] = List()

  def description(): String = {
    this.item_description
  }

  def setBasePrice(new_base: Double): Unit = {
    this.baseprice = new_base
  }

  def price(): Double = {
    var item_price = this.baseprice
    for (modify <- all_modifiers){
      item_price = modify.updatePrice(item_price)
    }
    item_price
  }

  def addModifier (some_modifier: Modifier): Unit ={
    all_modifiers = all_modifiers :+ some_modifier

  }

  def tax (): Double ={
    var item_tax: Double = 0.0
    for ( modify <- all_modifiers) {
      item_tax += modify.computeTax(price())
    }
    item_tax
  }

}
