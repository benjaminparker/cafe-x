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

    "produce bill for several menu items" in {

      val items = List("Cola", "Coffee", "Cheese Sandwich")
      Cafe.bill(items) shouldEqual BigDecimal("3.5")
    }

    "produce bill for all menu items with repetitions" in {

      val items = List("Cola", "Steak Sandwich", "Cola", "Coffee", "Cheese Sandwich", "Cheese Sandwich")
      Cafe.bill(items) shouldEqual BigDecimal("10.5")
    }
  }
}
