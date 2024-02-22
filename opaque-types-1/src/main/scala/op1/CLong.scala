package op1

opaque type CLong <: CIntegral =
  CIntegral

object CLong:
  def apply(i: Int)(using
      p: Platform
  ): CLong = p match
    case given (Platform.MacOSX64.type |
          Platform.LinuxX64.type) =>
      CIntegral(i)
    case given Platform.WinX64.type =>
      CIntegral(i)

  def apply(l: Long)(using
      p: Platform
  ): Option[CLong] = p match
    case given (Platform.LinuxX64.type |
          Platform.MacOSX64.type) =>
      Some(CIntegral(l))
    case _ => None

  def certain[P <: Platform](
      using
      p: P,
      tr: TypeRelation[P, CLong]
  )(l: tr.Real): CLong =
    CIntegral(l)

  given TypeRelation[
    Platform.LinuxX64.type |
      Platform.MacOSX64.type,
    CLong
  ] with
    type Real = Long

  given TypeRelation[
    Platform.WinX64.type,
    CLong
  ] with
    type Real = Int
