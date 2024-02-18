package op1

opaque type Meter = Int

object Meter:
  def apply(meters: Int): Meter =
    meters
