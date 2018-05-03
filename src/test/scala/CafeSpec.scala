import org.specs2.mutable.Specification

/*
The cafe has the following items for sale

Cola - Cold - 50p
Coffee - Hot - £1.00
Cheese Sandwich - Cold - £2.00
Steak Sandwich - Hot - £4.50

 */
class CafeSpec extends Specification {

  "Cafe" should {

    "produce bill with no service charge when all items are drinks" in {

      val items = List("Cola", "Coffee", "Coffee")
      Cafe.bill(items) shouldEqual BigDecimal("2.5")
    }

    "produce bill with 10 percent service charge when there is a food item" in {

      val items = List("Cola", "Steak Sandwich", "Coffee")
      Cafe.bill(items) shouldEqual BigDecimal("6.6")
    }
  }
}
