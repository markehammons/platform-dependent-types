package op1

opaque type CIntegral <: CVal =
  CVal

object CIntegral:
  def apply(a: Long): CIntegral =
    CVal(a)
  extension (
      cintegral: CIntegral
  )
    def asLong =
      cintegral.as[Long].get
