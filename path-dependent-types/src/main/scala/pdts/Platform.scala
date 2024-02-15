package pdts

sealed trait Platform:
  type CLong
  given clongIntegral
      : Integral[CLong]
  def clong(i: Int): CLong
  def clong(
      l: Long
  ): Option[CLong]

case object LinuxX64
    extends Platform:
  type CLong = Long
  given clongIntegral
      : Integral[CLong] =
    Numeric.LongIsIntegral
  def clong(i: Int): CLong =
    i.toLong
  def clong(
      i: Long
  ): Option[CLong] = Some(i)
  def clongCertain(
      i: Long
  ): CLong = i
case object WinX64
    extends Platform:
  type CLong = Int
  given clongIntegral
      : Integral[CLong] =
    Numeric.IntIsIntegral
  def clong(i: Int): CLong = i
  def clong(
      i: Long
  ): Option[CLong] = None
case object MacOSX64
    extends Platform:
  type CLong = Long
  given clongIntegral
      : Integral[CLong] =
    Numeric.LongIsIntegral
  def clong(i: Int): CLong =
    i.toLong
  def clong(
      i: Long
  ): Option[CLong] = None
  def clongCertain(
      i: Long
  ): CLong = i
