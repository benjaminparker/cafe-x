object Cafe {
  val items: Map[String, Item] = Map(
    "Cola" -> Item("Cola", Drink, BigDecimal("0.50")),
    "Coffee" -> Item("Coffee", Drink, BigDecimal("1.00")),
    "Cheese Sandwich" -> Item("Cheese Sandwich", Food, BigDecimal("2.00")),
    "Steak Sandwich" -> Item("Steak Sandwich", Food, BigDecimal("4.50"))
  )

  def bill(itemNames: List[String]): BigDecimal = {
    def addServiceCharge(total: BigDecimal) = {
      if (itemNames.exists(items(_).foodOrDrink == Food)) (total * BigDecimal(1.1))
      else total
    }

    val billTotal = itemNames.foldLeft(BigDecimal("0.00"))((t, n) => t + items(n).price)
    addServiceCharge(billTotal)
  }
}
