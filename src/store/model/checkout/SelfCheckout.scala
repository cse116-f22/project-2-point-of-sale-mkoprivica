package store.model.checkout

import store.model.items.Item
import store.view.SelfCheckoutGUI

class SelfCheckout() {


  var display: String = ""
  var inventory: Map[String, Item] = Map()
  var cart: List[Item] = List()

  def addItemToStore(barcode: String, item: Item): Unit = {
    // This method adds an item to your store's checkout system. It does not add an item to the customer's cart
    //
    this.inventory += (barcode -> item)
  }

  def numberPressed(number: Int): Unit = {
    //
    this.display += number
  }

  def clearPressed(): Unit = {
    this.display = ""
    //
  }

  def enterPressed(): Unit = {
    //
    var error = new Item("error",0.0)
    this.cart = this.cart :+ this.inventory.getOrElse(this.display,
      error)
    this.display = ""
  }

  def checkoutPressed(): Unit = {
  // TODO
  }
  def cashPressed(): Unit = {
    // TODO
  }

  def creditPressed(): Unit = {
    // TODO
  }

  def loyaltyCardPressed(): Unit = {
    // TODO
  }

  def displayString(): String = {
    ""
    this.display
    //
  }

  def itemsInCart(): List[Item] = {
    this.cart
  }

  def subtotal(): Double = {
    var subtotal: Double = 0.0
    for ( x <- this.cart){
      subtotal += x.price()
    }
    subtotal



  }

  def tax(): Double = {
    var tax: Double = 0.0
    for (x <- this.cart) {
      tax += x.tax()
    }
    tax
  }

  def total(): Double = {
    subtotal()+tax()
  }

  def prepareStore(): Unit = {
    // Similar to openMap in the Pale Blue Dot assignment, this method is not required and is
    // meant to help you run manual tests.
    //
    // This method is called by the GUI during setup. Use this method to prepare your
    // items and call addItemToStore to add their barcodes. Also add any sales/tax/etc to your
    // items.
    //
    // This method will not be called during testing and you should not call it in your tests.
    // Each test must setup its own items to ensure compatibility in AutoLab. However, you can
    // write a similar method in your Test Suite classes.

    // Example usage:
    val testItem: Item = new Item("test item", 100.0)
    this.addItemToStore("472", testItem)
  }

}
