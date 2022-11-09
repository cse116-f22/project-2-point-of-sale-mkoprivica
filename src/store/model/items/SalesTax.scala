package store.model.items

class SalesTax(percent_tax:Double) extends Modifier() {

  override def updatePrice(price_before_sale: Double): Double = {
    price_before_sale

  }

  override def computeTax(price_of_item: Double): Double = {
    price_of_item * ((percent_tax/100))
  }
}




/*test("Check Subtotal"){
  var testSelfCheckout: SelfCheckout = new SelfCheckout()
  var testItem: Item = new Item("test item", 100.0)
  var testItem2: Item = new Item("test item", 17.0)

  testSelfCheckout.addItemToStore("123", testItem)
  testSelfCheckout.addItemToStore("017", testItem2)

  val expected_empty : Double = 0.0
  val expected_unmodified : Double = 217.0
  val expected_saleToOne : Double = 161.0
  val expected_saleToAll : Double = 156.24
  val expected_tax : Double = 15.624
  val expected_total : Double = 171.864

  assert(Math.abs(testSelfCheckout.subtotal() - expected_empty) < epsilon)
  assert(Math.abs(testSelfCheckout.tax() - expected_empty) < epsilon)
  assert(Math.abs(testSelfCheckout.total() - expected_empty) < epsilon)

  //accepts single item in cart:
  testSelfCheckout.numberPressed(1)
  testSelfCheckout.numberPressed(2)
  testSelfCheckout.numberPressed(3)
  assert(testSelfCheckout.displayString() == "123")
  testSelfCheckout.enterPressed()
  assert(testSelfCheckout.itemsInCart() == List(testItem))

  //accepts same item twice in cart:
  testSelfCheckout.numberPressed(1)
  testSelfCheckout.numberPressed(2)
  testSelfCheckout.numberPressed(3)
  assert(testSelfCheckout.displayString() == "123")
  testSelfCheckout.enterPressed()
  assert(testSelfCheckout.itemsInCart() == List(testItem, testItem))

  //maintains order in cart + leading 0
  testSelfCheckout.numberPressed(0)
  testSelfCheckout.numberPressed(1)
  testSelfCheckout.numberPressed(7)
  assert(testSelfCheckout.displayString() == "017")
  testSelfCheckout.enterPressed()
  assert(testSelfCheckout.itemsInCart() == List(testItem, testItem, testItem2))

  assert(Math.abs(testSelfCheckout.subtotal() - expected_unmodified) < epsilon)
  assert(Math.abs(testSelfCheckout.tax() - expected_empty) < epsilon)

  val sale1: Sale = new Sale(20.0)
  val sale2: Modifier = new Sale(10.0)
  testItem.addModifier(sale1)
  testItem.addModifier(sale2)


  assert(Math.abs(testSelfCheckout.subtotal() - expected_saleToOne) < epsilon)
  assert(Math.abs(testSelfCheckout.tax() - expected_empty) < epsilon)

  testItem2.addModifier(sale1)
  testItem2.addModifier(sale2)

  assert(Math.abs(testSelfCheckout.subtotal() - expected_saleToAll) < epsilon)
  assert(Math.abs(testSelfCheckout.tax() - expected_empty) < epsilon)

  val tax1: SalesTax = new SalesTax(6.0)
  val tax2: Modifier = new SalesTax(4.0)
  testItem.addModifier(tax1)
  testItem.addModifier(tax2)
  testItem2.addModifier(tax1)
  testItem2.addModifier(tax2)

  assert(Math.abs(testSelfCheckout.subtotal() - expected_saleToAll) < epsilon)
  assert(Math.abs(testSelfCheckout.tax() - expected_tax) < epsilon)

  assert(Math.abs(testSelfCheckout.total() - expected_total) < epsilon) */



