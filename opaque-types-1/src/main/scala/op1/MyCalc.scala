package op1

trait MyCalc[A]:
  type B

object MyCalc:
  given MyCalc[Int] with
    type B = Float

  given MyCalc[Float] with
    type B = String
