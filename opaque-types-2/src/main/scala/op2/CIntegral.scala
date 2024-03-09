package op2

opaque type CIntegral <: CVal =
  CVal

object CIntegral:
  def apply[P <: Platform](
      using p: P, tr: TypeRelation[P, ?]
  )(
      value: tr.Real
  ): CIntegral = CVal(
    value
  )
