package store.model.checkout

import store.model.items.Item

abstract class State(checkout: SelfCheckout) {

  def enterPressed()

  def numberPressed(number: Int)

  def clearPressed()

  def checkoutPressed()

  def cashPressed()

  def creditPressed()





}
