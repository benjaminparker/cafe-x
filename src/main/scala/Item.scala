sealed trait FoodOrDrink
case object Food extends FoodOrDrink
case object HotFood extends FoodOrDrink
case object Drink extends FoodOrDrink

case class Item(name: String, foodOrDrink: FoodOrDrink, price: BigDecimal)
