package op1

import scala.reflect.TypeTest

opaque type CVal = Matchable

object CVal:
  def apply(a: Matchable): CVal =
    a

  extension (cval: CVal)
    def as[A <: Matchable](using
        TypeTest[Matchable, A]
    ): Option[A] =
      cval match
        case a: A => Some(a)
        case _    => None
