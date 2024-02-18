package op1

import scala.annotation.targetName

opaque type CLong <: CIntegral =
  CIntegral

object CLong:
  def apply(i: Int): CLong =
    CIntegral(i.toLong)

  def apply(l: Long)(using
      p: Platform
  ): Option[CLong] = p match
    case Platform.LinuxX64 |
        Platform.MacOSX64 =>
      Some(CIntegral(l))
    case _ => None

  def certain(l: Long)(using
      Platform.LinuxX64.type |
        Platform.MacOSX64.type
  ): CLong = CIntegral(l)
