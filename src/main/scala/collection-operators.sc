// ------------ Seq ------------

val seq = Seq(2)

val xSeq = seq :+ 10

xSeq :+ 100 // Seq[Int] = List(2, 10, 100)

100 +: xSeq // Seq[Int] = List(100, 2, 10)

// does not work for Seq
// xSeq :: 2
// xSeq ::: Seq(2)

// 2, 10
// 5 * 2 * 10 = 10 * 10 = 100
val z1 = (5 /: xSeq) (_ * _) // Int = 100

// 5 + 2 + 10 = 7 + 10 = 17
val z2 = (5 /: xSeq) (_ + _) // Int = 17


// ------------ List ------------

val list = List(5)

val xList = list :+ 10 // List[Int] = List(5, 10)

// prepend :+  or append +:
xList :+ 20 // List[Int] = List(5, 10, 20)
20 +: xList // List[Int] = List(20, 5, 10)

// add at the beginning (single item)
1 :: xList // List[Int] = List(1, 5, 10)
xList.::(1) // List[Int] = List(1, 5, 10)
List(1) :: xList // List(List(1), 5, 10)

// add at the beginning (collection)
List(2) ::: xList // List(2, 5, 10)
List(0, 0, 0) ::: xList // List(0, 0, 0, 5, 10)


// ------------ Map ------------

// does not support :: ::: :+ +:
val map = Map(1 -> "a")

val xMap = map + (2 -> "b") ++ Map(3 -> "c", 4 -> "d") // Map(1 -> a, 2 -> b, 3 -> c, 4 -> d)

// -- for a collection
val yMap = xMap - 1 -- Seq(2, 3) // Map(4 -> d)

// for an item
val zMap = xMap - (1, 2, 3) // Map(4 -> d)
