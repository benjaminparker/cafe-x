object Cafe {
  val items = Map(
    "Cola" -> BigDecimal("0.50"),
    "Coffee" -> BigDecimal("1.00"),
    "Cheese Sandwich" -> BigDecimal("2.00"),
    "Steak Sandwich" -> BigDecimal("4.50")
  )

  def bill(is: List[String]): BigDecimal = is.foldLeft(BigDecimal("0.00"))(_ + items(_))
}
