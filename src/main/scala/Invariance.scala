import model.{Animal, Cat, Dog}

/**
  * Invariant container
  */
class Container[A](newValue: A) {
  private var _value: A = newValue

  def value: A = _value
  def value_=(x: A): Unit = _value = x
}

/**
  * Container[Cat] is not a Container[Animal]
  * Cannot assign Container[Cat] to Container[Animal]
  * If that was possible we would end up with a Dog assigned to a Cat
  */
object Invariance extends App {
  val catContainer: Container[Cat] = new Container(Cat("Lucifurr"))

  // does not compile
  //val animalContainer: Container[Animal] = catContainer
  //animalContainer.value = Dog("Rambo")
  //val cat: Cat = catContainer.value
}
