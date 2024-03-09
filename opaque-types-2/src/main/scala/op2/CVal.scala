package op2

import scala.reflect.TypeTest

opaque type CVal = Matchable

object CVal:
  def apply[P <: Platform](using
      p: P,
      tr: TypeRelation[P, ?]
  )(
      value: tr.Real
  ): CVal = value
  extension [A <: CVal](
      cval: A
  )
    inline def extract[
        P <: Platform
    ](using
        p: P,
        tr: TypeRelation[P, A],
        tt: TypeTest[
          Matchable,
          tr.Real
        ]
    ) = cval match
      case ret: tr.Real =>
        ret
      case _ =>
        throw Error(
          "the backing type wasn't what was expected"
        )
