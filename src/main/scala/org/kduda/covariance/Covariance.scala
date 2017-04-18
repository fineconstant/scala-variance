package org.kduda.covariance

import model.{Animal, Cat, Dog}

object Covariance extends App {
  def printAnimalNames(animals: List[Animal]): Unit = {
    animals.foreach(println)
  }

  val cats: List[Cat] = List(Cat("Whiskers"), Cat("Tom"))
  val dogs: List[Dog] = List(Dog("Fido"), Dog("Rex"))
  val animals = cats ++ dogs

  printAnimalNames(cats)

  printAnimalNames(dogs)

  printAnimalNames(animals)
}
