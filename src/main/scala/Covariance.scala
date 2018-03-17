import model.{Animal, Cat, Dog}


/**
  * Remember that List is covariant
  * type List[+A]
  */
trait ListPrinter[T] {
  def printElements(xs: List[T]): Unit
}

class AnimalListPrinter extends ListPrinter[Animal] {
  override def printElements(xs: List[Animal]): Unit =
    xs.foreach(x => println(s"Animal Type: [${x.getClass.getSimpleName}], Animal: [$x]"))
}

object Covariance extends App {
  val printer = new AnimalListPrinter

  val cats: List[Cat] = List(Cat("Whiskers"), Cat("Tom"))
  val dogs: List[Dog] = List(Dog("Fido"), Dog("Rex"))
  val animals: List[Animal] = List(Dog("Fido"), Cat("Purr"))

  printer.printElements(cats)

  printer.printElements(dogs)

  printer.printElements(animals)
}
