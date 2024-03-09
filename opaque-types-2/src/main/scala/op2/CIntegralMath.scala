package op2
import compiletime.{
  summonInline,
  codeOf,
  error,
  erasedValue
}
import scala.annotation.switch

trait CIntegralMath[
    A
]:
  def parseString(str: String)(
      using Platform
  ): Option[A]
  def minus(x: A, y: A)(using
      Platform
  ): A
  def toDouble(x: A)(using
      Platform
  ): Double
  def toLong(x: A)(using
      Platform
  ): Long
  def times(x: A, y: A)(using
      Platform
  ): A
  def rem(x: A, y: A)(using
      Platform
  ): A
  def compare(x: A, y: A)(using
      Platform
  ): Int
  def negate(x: A)(using
      Platform
  ): A
  def toInt(x: A)(using
      Platform
  ): Int
  def quot(x: A, y: A)(using
      Platform
  ): A
  def toFloat(x: A)(using
      Platform
  ): Float
  def plus(x: A, y: A)(using
      Platform
  ): A

object CIntegralMath:
  inline def getIntegral[A] =
    summonInline[Integral[A]]

  inline def summonIntegral[
      P <: Platform,
      A <: CIntegral
  ](tr: TypeRelation[P, A]) =
    summonInline[Integral[
      tr.Real
    ]]

  inline def test[
      A <: CIntegral
  ](using
      p: Platform
  ): Integral[?] =
    (p: @switch) match
      case Platform.WinX64 =>
        summonIntegral(
          summonInline[TypeRelation[
            Platform.WinX64.type,
            A
          ]]
        )
      case _ => ???

  inline def derive[
      A <: CIntegral
  ]: CIntegralMath[A] =
    new CIntegralMath[A] {
      def getIntegral(using
          p: Platform
      ): Integral[A] =
        val integral
            : Integral[?] =
          (p: @switch) match
            case Platform.WinX64 =>
              summonIntegral(
                summonInline[
                  TypeRelation[
                    Platform.WinX64.type,
                    A
                  ]
                ]
              )
            case Platform.LinuxX64 =>
              summonIntegral(
                summonInline[
                  TypeRelation[
                    Platform.LinuxX64.type,
                    A
                  ]
                ]
              )
            case Platform.MacOSX64 =>
              summonIntegral(
                summonInline[
                  TypeRelation[
                    Platform.MacOSX64.type,
                    A
                  ]
                ]
              )

        integral
          .asInstanceOf[Integral[
            A
          ]]

      override def minus(
          x: A,
          y: A
      )(using Platform): A =
        getIntegral.minus(x, y)

      override def rem(
          x: A,
          y: A
      )(using Platform): A =
        getIntegral.rem(x, y)

      override def parseString(
          str: String
      )(using
          Platform
      ): Option[A] =
        getIntegral.parseString(
          str
        )

      override def toDouble(
          x: A
      )(using Platform): Double =
        getIntegral.toDouble(x)

      override def plus(
          x: A,
          y: A
      )(using Platform): A =
        getIntegral.plus(x, y)

      override def toFloat(x: A)(
          using Platform
      ): Float =
        getIntegral.toFloat(x)

      override def quot(
          x: A,
          y: A
      )(using Platform): A =
        getIntegral.quot(x, y)

      override def negate(x: A)(
          using Platform
      ): A =
        getIntegral.negate(x)

      override def toLong(x: A)(
          using Platform
      ): Long =
        getIntegral.toLong(x)

      override def toInt(x: A)(
          using Platform
      ): Int =
        getIntegral.toInt(x)

      override def compare(
          x: A,
          y: A
      )(using Platform): Int =
        getIntegral.compare(x, y)

      override def times(
          x: A,
          y: A
      )(using Platform): A =
        getIntegral.times(x, y)
    }
