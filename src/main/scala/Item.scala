sealed trait ServiceChargeCategory {
  val rate: BigDecimal
  val min: Int
}

case object Drink extends ServiceChargeCategory {
  val rate = BigDecimal(0.0)
  val min = 0
}

case object Food extends ServiceChargeCategory {
  val rate = BigDecimal(0.1)
  val min = Int.MaxValue
}

case object HotFood extends ServiceChargeCategory {
  val rate = BigDecimal(0.2)
  val min = 20
}

case object Premium extends ServiceChargeCategory {
  val rate = BigDecimal(0.25)
  val min = 40
}

case class Item(name: String, serviceChargeCategory: ServiceChargeCategory, price: BigDecimal)
