package tests

import org.scalatest.FunSuite
import store.model.checkout.SelfCheckout
import store.model.items._

class Task3 extends FunSuite {
 val epsilon: Double = .001
 val error_cart: Double = 0.0

 test ( "Task 3 Tests"){

  var emptySelfCheckout: SelfCheckout = new SelfCheckout()
  var testSelfCheckout: SelfCheckout = new SelfCheckout()
  var testItem: Item = new Item("test item", 100.0)
  testSelfCheckout.addItemToStore("123", testItem)

  //  Testing if no item has been scanned

  emptySelfCheckout.enterPressed()
  assert(emptySelfCheckout.itemsInCart() == List(emptySelfCheckout.itemsInCart().last))
  assert(emptySelfCheckout.itemsInCart().last.description() == "error")
  assert(Math.abs(emptySelfCheckout.itemsInCart().last.price() - error_cart) < epsilon)


  // Testing if an item can be rescanned by pressing enter

   testSelfCheckout.numberPressed(1)
   testSelfCheckout.numberPressed(2)
   testSelfCheckout.numberPressed(3)
   assert(testSelfCheckout.displayString() == "123")
   testSelfCheckout.enterPressed()
   assert(testSelfCheckout.itemsInCart() == List(testItem))
   testSelfCheckout.enterPressed()
   testSelfCheckout.enterPressed()
   assert(testSelfCheckout.itemsInCart() == List(testItem, testItem, testItem))


  // Testing the functionality of the clear and number buttons

  testSelfCheckout.numberPressed(5)
  testSelfCheckout.clearPressed()
  testSelfCheckout.enterPressed()
  assert(testSelfCheckout.itemsInCart() == List(testItem,testItem,testItem,testSelfCheckout.itemsInCart().last))
  assert(testSelfCheckout.itemsInCart().last.description() == "error")
  assert(Math.abs(testSelfCheckout.itemsInCart().last.price() - error_cart) < epsilon)

  // Testing that checkout button works

  testSelfCheckout.checkoutPressed()

  assert(testSelfCheckout.displayString() == "cash or credit")

  testSelfCheckout.numberPressed(1)
  testSelfCheckout.numberPressed(2)
  testSelfCheckout.numberPressed(3)

  testSelfCheckout.clearPressed()

  assert(testSelfCheckout.displayString() == "cash or credit")

  // Testing that cash and credit buttons have the same function

  testSelfCheckout.cashPressed()

  assert(testSelfCheckout.displayString() == "")
  assert(testSelfCheckout.itemsInCart() == List())

  testSelfCheckout.numberPressed(1)
  testSelfCheckout.numberPressed(2)
  testSelfCheckout.numberPressed(3)
  testSelfCheckout.enterPressed()

  testSelfCheckout.checkoutPressed()
  testSelfCheckout.cashPressed()


  assert(testSelfCheckout.displayString() == "")
  assert(testSelfCheckout.itemsInCart() == List())


  testSelfCheckout.enterPressed()
  assert(testSelfCheckout.itemsInCart() == List(testSelfCheckout.itemsInCart().last))
  assert(testSelfCheckout.itemsInCart().last.description() == "error")
  assert(Math.abs(testSelfCheckout.itemsInCart().last.price() - error_cart) < epsilon)


 }
}


