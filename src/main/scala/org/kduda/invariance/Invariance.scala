package org.kduda.invariance

import model.{Animal, Cat, Dog}

object Invariance extends App {
  val catContainer: Container[Cat] = new Container(Cat("Felix"))
  val animalContainer: Container[Animal] = catContainer // Container[Cat] is not a Container[Animal]
  animalContainer.setValue(Dog("Spot")) // Oops, we'd end up with a Dog assigned to a Cat
  val cat: Cat = catContainer.getValue
}
