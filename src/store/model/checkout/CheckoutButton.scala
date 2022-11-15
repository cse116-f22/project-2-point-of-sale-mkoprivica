package store.model.checkout

import store.model.items.Item

class CheckoutButton(checkout: SelfCheckout) extends State(checkout){

  override def enterPressed(): Unit = {
    var error = new Item("error", 0.0)
    checkout.cart = checkout.cart :+ checkout.cart.last
    checkout.display = ""

  }

  def numberPressed(number: Int): Unit = {
    checkout.display += number
    checkout.state = new Clear(checkout)
  }

  override def clearPressed(): Unit = {
    checkout.state = new Clear(checkout)
  }

  override def checkoutPressed(): Unit = {
    checkout.display = "cash or credit"
    checkout.state = new CheckoutCart(checkout)
  }

  override def cashPressed(): Unit = {

  }

  override def creditPressed(): Unit = {

  }

}
