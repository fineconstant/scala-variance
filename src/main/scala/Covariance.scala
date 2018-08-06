import model.{Animal, Cat, Dog}

/**
  * Note that List is covariant List[+A]:
  * [[scala.collection.immutable.List]]
  */
trait ListPrinter[T] {

  /**
    * Because List is covariant, this method wil be able to
    * print List of T's and also List of every subtype of T.
    */
  def printElements(xs: List[T]): Unit
}

class AnimalListPrinter extends ListPrinter[Animal] {
  override def printElements(xs: List[Animal]): Unit =
    xs.foreach(x => println(s"Animal is: [$x]"))
}

object Covariance extends App {
  val printer = new AnimalListPrinter

  val cats: List[Cat] = List(Cat("Orange Thunder"), Cat("Grumpy face"))
  val dogs: List[Dog] = List(Dog("Sherlock Bones"), Dog("Prince of Barkness"))
  val animals: List[Animal] = List(Dog("Chew Barka"), Cat("Stinkster"))

  printer.printElements(cats)
  printer.printElements(dogs)
  printer.printElements(animals)
}
