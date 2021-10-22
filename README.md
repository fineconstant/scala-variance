* #### [Invariant](src/main/scala/Invariance.scala)
    * Usage: `class Foo[A]`
    * Definition: `Stack[A]` is a subtype of `Stack[B]` if and only if `A = B` i. e. `A` and `B` are the same types
    * Example: `Cat` is a subtype of `Animal`; however, `Container[Cat]` is not a `Container[Animal]`, nor is the reverse true.

* #### [Covariant](src/main/scala/Covariance.scala)
    * Usage: `class Bar[+A]`
    * Definition: If `A` is a subtype of `B` then `List[A]` is a subtype of `List[B]` 
    * Covariant position: used in places of return types, output in general
    * Example: \
      `Cat` is a subtype of `Animal`, `Dog` is a subtype of `Animal` as well.\
      `List[Cat]` is a `List[Animal]` and a `List[Dog]` is also a `List[Animal]`.\
      Therefore, both `List[Cat]` and `List[Dog]` can be substituted for (used instead of) `List[Animal]`.\
      It is possible to write `val x: List[Animal] = List(Dog("Tom"))` and thanks to that `ListPrinter[Animal]` can print every subtype of `List[Animal]`. \
      It is __NOT__ possible to assign `List[Animal]` to `List[Dog]`.
 
* #### [Contravariant](src/main/scala/Contravariance.scala)
    * Usage `class Baz[-A]`
    * Definition: \
      Contravariance is the opposite of covariance.\
      If `A` is a subtype of `B` then `Writer[B]` is a subtype of `Writer[A]`
    * Contravariant position: used in places of parameters - input types, input in general
    * `Cat` is a subtype of `Animal`\
      `Printer[Animal]` is a subclass of `Printer[Cat]`; therefore, it can be used as a substitute of a `Printer[Cat]`, not inverse!
      `val x: Printer[Cat] = Printer[Animal]`. \
