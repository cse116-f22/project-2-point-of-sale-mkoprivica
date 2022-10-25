package tests

import org.scalatest.FunSuite
import store.model.checkout.SelfCheckout
import store.model.items.Item

class Task1 extends FunSuite {

  var testSelfCheckout: SelfCheckout = new SelfCheckout()
  var testItem: Item = new Item("test item", 100.0)
  var testItem2: Item = new Item("test item", 17.0)
  var error: Item = new Item("error", 0.0)

  testSelfCheckout.addItemToStore("123", testItem)
  testSelfCheckout.addItemToStore("017", testItem2)

  test("display empty string") {
    assert(testSelfCheckout.displayString() == "")
  }

  test("doubles/overcharging") {
    var epsilon: Double = .001
    var expected_base: Double = 100.0
    var expected_setbase: Double = 50.0

    assert(testItem.description() == "test item")
    assert(Math.abs(testItem.price() - expected_base) < epsilon)
    testItem.setBasePrice(50.0)
    assert(Math.abs(testItem.price() - expected_setbase) < epsilon)
  }
  test("accepts single item in cart") {
    testSelfCheckout.numberPressed(1)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.numberPressed(3)
    assert(testSelfCheckout.displayString() == "123")
    testSelfCheckout.enterPressed()
    assert(testSelfCheckout.itemsInCart() == List(testItem))
  }
  test("accepts same item twice in cart") {
    testSelfCheckout.numberPressed(1)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.numberPressed(3)
    assert(testSelfCheckout.displayString() == "123")
    testSelfCheckout.enterPressed()
    assert(testSelfCheckout.itemsInCart() == List(testItem, testItem))
  }
  test("maintains order in cart + leading 0") {
    testSelfCheckout.numberPressed(0)
    testSelfCheckout.numberPressed(1)
    testSelfCheckout.numberPressed(7)
    assert(testSelfCheckout.displayString() == "017")
    testSelfCheckout.enterPressed()
    assert(testSelfCheckout.itemsInCart() == List(testItem, testItem, testItem2))
  }

  test("invalid barcode") {

    testSelfCheckout.numberPressed(1)
    testSelfCheckout.numberPressed(5)
    assert(testSelfCheckout.displayString() == "15")
    testSelfCheckout.enterPressed()
    assert(testSelfCheckout.itemsInCart() == List(testItem, testItem, testItem2, error))
  }


  test("clear button") {
    testSelfCheckout.numberPressed(7)
    assert(testSelfCheckout.displayString() == "7")
    testSelfCheckout.clearPressed()
    assert(testSelfCheckout.displayString() == "")
  }


}
