package op1

opaque type PositiveInt = Int

object PositiveInt:
  def apply(
      int: Int
  ): PositiveInt =
    if int >= 0 then int
    else
      throw new Error(
        "Not Positive!"
      )
