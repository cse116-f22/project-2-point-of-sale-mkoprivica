package store.model.checkout

import store.model.items.Item

class Rescan(checkout: SelfCheckout) extends State(checkout){

  override def enterPressed(): Unit = {
    val error = new Item("error", 0.0)
    checkout.cart = checkout.cart :+ checkout.inventory.getOrElse(checkout.display,
      error)
    checkout.display = ""
    checkout.state = new CheckoutButton(checkout)

  }

  def numberPressed(number: Int): Unit = {
    checkout.display += number
    checkout.state = new Clear(checkout)
  }

  override def clearPressed(): Unit = {
    checkout.display = ""

  }

  override def checkoutPressed(): Unit = {
    checkout.state = new CheckoutCart(checkout)
  }

  override def cashPressed(): Unit = {

  }

  override def creditPressed(): Unit = {

  }

}
