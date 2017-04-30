* #### Invariant
    * `class Foo[A]`
    * `Stack[A]` is a subtype of `Stack[B]` if and only if `A = B`
    *  A `Container[Cat]` is not a `Container[Animal]`, nor is the reverse true.
 
* #### Covariant
    * `class Bar[+A]`
    * If `A` is a subtype of `B` then `List[A]` is a subtype of `List[B]` 
    * `List[model.Cat]` is a `List[model.Animal]` and a `List[model.Dog]` is also a `List[model.Animal]`.
    Therefore, both `List[model.Cat]` and `List[model.Dog]` can be substituted for a `List[model.Animal]`.
    
* #### Contravariant
    * `class Baz[-A]`
    * Opposite to covariance.
    * If `A` is a subtype of `B` then `Writer[B]` is a subtype of `Writer[A]` 
    * `Printer[Animal]` < `Printer[Cat]`
      
      `Printer[Animal]` is a subclass of `Printer[Cat]`; therefore, it can be used as a substitute of a `Printer[Cat]`, not inverse!

* ##### [Collection-operators.sc](src/main/scala/collection-operators.sc)
    * Seq operators
    * List operators
    * Map operators