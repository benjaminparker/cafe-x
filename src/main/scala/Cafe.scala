object Cafe {
  val items: Map[String, Item] = Map(
    "Cola" -> Item("Cola", Drink, BigDecimal("0.50")),
    "Coffee" -> Item("Coffee", Drink, BigDecimal("1.00")),
    "Cheese Sandwich" -> Item("Cheese Sandwich", Food, BigDecimal("2.00")),
    "Lobster" -> Item("Lobster", Premium, BigDecimal("25.00")),
    "Steak Sandwich" -> Item("Steak Sandwich", HotFood, BigDecimal("4.50"))
  )

  def bill(itemNames: List[String]): BigDecimal = {
    def addServiceCharge(total: BigDecimal) = {
      if (itemNames.exists(items(_).foodOrDrink == Premium)) total + (total * BigDecimal(0.25)).min(40)
      else if (itemNames.exists(items(_).foodOrDrink == HotFood)) total + (total * BigDecimal(0.2)).min(20)
      else if (itemNames.exists(items(_).foodOrDrink == Food)) total + (total *  BigDecimal(0.1))
      else total
    }

    val billTotal = itemNames.foldLeft(BigDecimal("0.00"))(_ + items(_).price)
    addServiceCharge(billTotal)
  }
}
