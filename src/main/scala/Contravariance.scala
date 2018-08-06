import model.{Animal, Cat}

/**
  * Printer is contravariant
  */
trait Printer[-A] {
  def print(value: A): Unit
}

class AnimalPrinter extends Printer[Animal] {
  def print(animal: Animal): Unit =
    println("The animal's name is: " + animal.name)
}

class CatPrinter extends Printer[Cat] {
  def print(cat: Cat): Unit = println("The cat's name is: " + cat.name)
}

/**
  * If a Printer[Cat] knows how to print any Cat to the console,
  * and a Printer[Animal] knows how to print any Animal to the console,
  * it makes sense that a Printer[Animal] would also know how to print any Cat.
  * *
  * The inverse relationship does not apply, because a Printer[Cat] does not know how to print any Animal to the console.
  * *
  * Therefore, we should be able to substitute a Printer[Animal] for a Printer[Cat],
  * if we wish, and making Printer[A] contravariant allows us to do exactly that.
  * *
  * Superclass      > Subclass
  * Subclass        < Superclass
  * Animal          > Cat
  * Printer[Animal] < Printer[Cat]
  * *
  * Printer[Animal] is a subclass of Printer[Cat]; therefore, it can be used as a substitute of a Printer[Cat], not inverse!
  **/
object Contravariance extends App {
  val someCat: Cat = Cat("Captain Meow")
  val someDog: Cat = Cat("Prince of Barkness")

  // we can pass Printer[Animal] here
  def printMyCat(printer: Printer[Cat]): Unit = {
    printer.print(someCat)
    // does not compile
    //printer.print(someDog)
  }

  // we CAN NOT pass Printer[Cat] or Printer[Dog] here
  // animal can be a Dog or a Cat, so to print it we need more general printer i.e. printer for an Animal
  def printMyAnimal(printer: Printer[Animal]): Unit = {
    printer.print(someCat)
    printer.print(someDog)
  }

  val catPrinter: Printer[Cat] = new CatPrinter
  val animalPrinter: Printer[Animal] = new AnimalPrinter

  printMyCat(catPrinter) // method parameter: Printer[Cat], actually passed: Printer[Cat]
  printMyCat(animalPrinter) // method parameter: Printer[Cat], actually passed: Printer[Animal]

  printMyAnimal(animalPrinter) // method parameter: Printer[Animal], actually passed: Printer[Animal]
  // does not compile
  //printMyAnimal(catPrinter) // method parameter: Printer[Animal], actually passed: Printer[Cat]
}
