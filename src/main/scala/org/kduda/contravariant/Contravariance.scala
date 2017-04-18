package org.kduda.contravariant

import model.{Animal, Cat}

object Contravariance extends App {
  val myCat: Cat = Cat("Boots")

  def printMyCat(printer: Printer[Cat]): Unit = {
    printer.print(myCat)
  }

  def printMyAnimal(printer: Printer[Animal]): Unit = {
    printer.print(myCat)
  }

  val catPrinter: Printer[Cat] = new CatPrinter
  val animalPrinter: Printer[Animal] = new AnimalPrinter
  printMyCat(catPrinter)
  printMyCat(animalPrinter)

  printMyAnimal(animalPrinter)
  // printMyAnimal(catPrinter) does not compile
}