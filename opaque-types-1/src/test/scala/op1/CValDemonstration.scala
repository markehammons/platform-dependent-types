package op1

class CValDemonstration
    extends munit.FunSuite:
  test("demo 1") {
    val cval = CVal(5)

    cval.as[5]

    assertEquals(
      cval.as[Int],
      Some(5)
    )
  }
