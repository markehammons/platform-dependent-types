package op2

import scala.reflect.TypeTest

opaque type CLong <: CIntegral =
  CIntegral

object CLong:
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

  def apply(i: Int)(using
      p: Platform
  ): CLong = p match
    case given (Platform.LinuxX64.type |
          Platform.MacOSX64.type) =>
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

  given [P <: Platform](using
      p: P,
      tr: TypeRelation[P, CLong],
      int: Integral[tr.Real],
      tt: TypeTest[
        Matchable,
        tr.Real
      ]
  ): Integral[CLong] with
    def compare(
        x: CLong,
        y: CLong
    ): Int = int.compare(
      x.extract,
      y.extract
    )
    def fromInt(x: Int): CLong =
      CLong.certain(
        int.fromInt(x)
      )
    def minus(
        x: CLong,
        y: CLong
    ): CLong = CLong.certain(
      int.minus(
        x.extract,
        y.extract
      )
    )
    def negate(x: CLong): CLong =
      CLong.certain(x.extract)
    def toDouble(
        x: CLong
    ): Double =
      int.toDouble(x.extract)
    def toFloat(
        x: CLong
    ): Float =
      int.toFloat(x.extract)
    def toLong(x: CLong): Long =
      int.toLong(x.extract)
    def parseString(
        str: String
    ): Option[CLong] = int
      .parseString(str)
      .map(CLong.certain)
    def plus(
        x: CLong,
        y: CLong
    ): CLong = CLong.certain(
      int.plus(
        x.extract,
        y.extract
      )
    )
    def quot(
        x: CLong,
        y: CLong
    ): CLong = CLong.certain(
      int.quot(
        x.extract,
        y.extract
      )
    )
    def rem(
        x: CLong,
        y: CLong
    ): CLong = CLong.certain(
      int.rem(
        x.extract,
        y.extract
      )
    )
    def times(
        x: CLong,
        y: CLong
    ): CLong = CLong.certain(
      int.times(
        x.extract,
        y.extract
      )
    )
    def toInt(x: CLong): Int =
      int.toInt(x.extract)

  given CIntegralMath[CLong] =
    CIntegralMath.derive
