package op1

opaque type CIntegral <: CVal =
  CVal

object CIntegral:
  def apply[P <: Platform](using
      p: P,
      tr: TypeRelation[P, ?]
  )(a: tr.Real): CIntegral =
    CVal(a)

  extension (
      cintegral: CIntegral
  )
    def asLong =
      cintegral.as[Long].get
