package op2

class CLongDemonstration
    extends munit.FunSuite:

  given Platform =
    Platform.WinX64
  test("demo 1") {
    val value: Matchable =
      summon[Platform] match
        case given Platform.WinX64.type =>
          CLong
            .certain(5)
            .extract
        case given (Platform.MacOSX64.type |
              Platform.LinuxX64.type) =>
          CLong
            .certain(5L)
            .extract

    value match
      case i: Int =>
        assertEquals(i, 5)
      case l: Long =>
        assertEquals(l, 5L)
      case _ => ???
  }

  test("demo 2") {
    val value = CLong(5)

    import scala.math.Integral.Implicits.*
    import CLong.given_Integral_CLong

    val res =
      summon[Platform] match
        case given Platform.WinX64.type =>
          (value + value).toInt
        case given (Platform.MacOSX64.type |
              Platform.LinuxX64.type) =>
          (value + value).toInt

    assertEquals(res, 10)
  }

  test("demo 3") {
    val value = CLong(5)

    val value2 = CLong(2L)

    assertEquals(value2, None)
  }

  test("demo 4") {
    assertNoDiff(
      compileErrors(
        "CIntegralMath.test[CLong]"
      ),
      ""
    )
  }

  test("demo 5") {
    val a = CLong(5)
    val b = CLong(6)
    val math = summon[
      CIntegralMath[CLong]
    ]

    assertEquals(
      math.toInt(
        math.plus(a, b)
      ),
      11
    )
  }
