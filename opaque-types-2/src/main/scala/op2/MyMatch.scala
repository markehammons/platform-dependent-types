package op2 

object MyMatches:
  type MyMatch[A] = A match
    case Int    => Float
    case String => Int
    case Float  => Double

  val x: MyMatch[Int] = 5f

  trait A
  sealed trait B extends A
  sealed trait C extends A

  type MyMatch2[A] = A match
    case B => Int
    case C => Float

  val y: MyMatch2[C] =
    5f // I compile now
