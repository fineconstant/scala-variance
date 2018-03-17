import model.{Animal, Cat, Dog}


class Container[A](constValue: A) {
  private var _value: A = constValue

  def value: A = _value
  def value_=(x: A): Unit = _value = x
}

object Invariance extends App {
  val catContainer: Container[Cat] = new Container(Cat("Felix"))

  // Container[Cat] is not a Container[Animal]
  // Cannot assign Container[Cat] to Container[Animal]
  val animalContainer: Container[Animal] = catContainer

  // If that was possible we'd end up with a Dog assigned to a Cat
  animalContainer.value = Dog("Spot")
  val cat: Cat = catContainer.value
}
