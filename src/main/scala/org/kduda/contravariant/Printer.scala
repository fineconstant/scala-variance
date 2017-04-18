package org.kduda.contravariant

import model.{Animal, Cat}

abstract class Printer[-A] {
  def print(value: A): Unit
}

class AnimalPrinter extends Printer[Animal] {
  def print(animal: Animal): Unit = println("The animal's name is: " + animal.name)
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
  **/

/**
  * Superclass      > Subclass
  * Subclass        < Superclass
  * Animal          > Cat
  * Printer[Animal] < Printer[Cat]
  * *
  * Printer[Animal] is a subclass of Printer[Cat]; therefore, it can be used as a substitute of a Printer[Cat], not inverse!
  **/
