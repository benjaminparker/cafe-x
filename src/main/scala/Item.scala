sealed trait ServiceChargeCategory
case object Food extends ServiceChargeCategory
case object HotFood extends ServiceChargeCategory
case object Drink extends ServiceChargeCategory
case object Premium extends ServiceChargeCategory

case class Item(name: String, foodOrDrink: ServiceChargeCategory, price: BigDecimal)
