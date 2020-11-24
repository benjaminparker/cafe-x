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
      val maxCategory = itemNames.map(items(_)).maxBy(_.serviceChargeCategory.rate).serviceChargeCategory
      total + (total * maxCategory.rate).min(maxCategory.min)
    }

    val billTotal = itemNames.foldLeft(BigDecimal(0))(_ + items(_).price)
    addServiceCharge(billTotal)
  }
}
