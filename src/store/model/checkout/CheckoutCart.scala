package store.model.checkout

import store.model.items.Item

class CheckoutCart(checkout: SelfCheckout) extends State(checkout){

  override def enterPressed(): Unit = {


  }

  def numberPressed(number: Int): Unit = {

  }

  override def clearPressed(): Unit = {

  }

  override def checkoutPressed(): Unit = {
    checkout.display = "cash or credit"
  }

  override def cashPressed(): Unit = {
    checkout.display = ""
    checkout.cart = List()
    checkout.state = new Rescan(checkout)
  }

  override def creditPressed(): Unit = {
    checkout.display = ""
    checkout.cart = List()
    checkout.state = new Rescan(checkout)
  }


}
