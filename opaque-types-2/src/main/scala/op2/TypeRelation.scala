package op2

trait TypeRelation[
    -P <: Platform,
    A <: CVal
]:
  type Real <: Matchable
