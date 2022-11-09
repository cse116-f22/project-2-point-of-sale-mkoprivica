package tests

import org.scalatest.FunSuite
import store.model.checkout.SelfCheckout
import store.model.items._

class Task2 extends FunSuite {
 val epsilon: Double = .001

 test ( "Check price() and tax() method"){

  val bp : Double = 100.0
  val expected_price: Double = 72.0
  val expected_tax1: Double = 0.0
  val expected_tax2: Double = 7.2
  val expected_total: Double = expected_price + expected_tax2


  val testSelfCheckout: SelfCheckout = new SelfCheckout()
  val item: Item = new Item("testing",100.0)
  testSelfCheckout.addItemToStore("123", item)

  assert(Math.abs(item.price() - bp) < epsilon)
  assert(Math.abs(item.tax() - expected_tax1) < epsilon)

  val sale1: Sale = new Sale(20.0)
  val sale2: Modifier = new Sale(10.0)
  item.addModifier(sale1)
  item.addModifier(sale2)

  assert(Math.abs(item.price() - expected_price) < epsilon)
  assert(Math.abs(item.tax() - expected_tax1) < epsilon)

  val tax1: SalesTax = new SalesTax(6.0)
  val tax2: Modifier = new SalesTax(4.0)
  item.addModifier(tax1)
  item.addModifier(tax2)

  assert(Math.abs(item.price() - expected_price) < epsilon)
  assert(Math.abs(item.tax() - expected_tax2) < epsilon)

  testSelfCheckout.numberPressed(1)
  testSelfCheckout.numberPressed(2)
  testSelfCheckout.numberPressed(3)
  testSelfCheckout.enterPressed()

  assert(Math.abs(testSelfCheckout.subtotal() - expected_price) < epsilon)
  assert(Math.abs(testSelfCheckout.tax() - expected_tax2) < epsilon)
  assert(Math.abs(testSelfCheckout.total() - expected_total) < epsilon)

 }
 test("Check BottleDeposit"){
  val bottle : BottleDeposit = new BottleDeposit(100.0)

  val expected_update : Double = 47.0
  val expected_compute : Double = 100.0

  assert(Math.abs(bottle.updatePrice(47.0) - expected_update) < epsilon)
  assert(Math.abs(bottle.computeTax(47.0) - expected_compute) < epsilon)
  assert(Math.abs(bottle.computeTax(12.0) - expected_compute) < epsilon)

 }
 test("Check Subtotal"){


  }
 }