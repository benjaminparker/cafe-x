import org.specs2.mutable.Specification

/*
The cafe has the following items for sale

Cola - Cold - 50p
Coffee - Hot - £1.00
Cheese Sandwich - Cold - £2.00
Steak Sandwich - Hot - £4.50


Joseph Griffiths	11:00 AM
Exercise 3 – Premium Menu Items	(15 Minutes)

1.	Lobster, a premium item, is added to the menu at a cost of £25 .....  31.25
2.	When purchased items include any premium food apply a service charge of 25% to the total bill to a max of £40
Exercise 3 – Premium Menu Items	(15 Minutes)

 */
class CafeSpec extends Specification {

  "Cafe" should {

    "produce bill with no service charge when all items are drinks" in {

      val items = List("Cola", "Coffee", "Coffee")
      Cafe.bill(items) shouldEqual BigDecimal("2.5")
    }

    "produce bill with 10 percent service charge when there is a food item" in {

      val items = List("Cola", "Cheese Sandwich", "Coffee")
      Cafe.bill(items) shouldEqual BigDecimal("3.85")
    }

    "produce bill with 20 percent service charge when there is a hot food item" in {

      val items = List("Cola", "Steak Sandwich", "Steak Sandwich", "Cheese Sandwich")
      Cafe.bill(items) shouldEqual BigDecimal("13.80")
    }

    "produce bill with maximum 20 pounds service charge when there is a hot food item" in {

      val items = twentySteakSandwiches ::: fiveCheeseSandwiches ::: List("Coffee", "Cola")
      Cafe.bill(items) shouldEqual BigDecimal("121.50")
    }

    "produce bill with 25 percent service charge when there is a premium food item" in {

      val items = List("Cola", "Steak Sandwich", "Lobster")
      Cafe.bill(items) shouldEqual BigDecimal("37.50")
    }

    "produce bill with maximum 40 pounds service charge when there is a premium food item" in {

      val items = tenLobsters ::: List("Coffee", "Cola")
      Cafe.bill(items) shouldEqual BigDecimal("291.50")
    }
  }

  def twentySteakSandwiches: List[String] = List.fill(20)("Steak Sandwich")
  def tenLobsters: List[String] = List.fill(10)("Lobster")
  def fiveCheeseSandwiches: List[String] = List.fill(5)("Cheese Sandwich")
}
