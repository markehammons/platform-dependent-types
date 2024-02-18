package op1

class CLongDemonstration
    extends munit.FunSuite:
  given Platform =
    Platform.LinuxX64

  test("demo 1") {
    val clong1 = CLong(5)
    val clong2 = CLong(5L)

    assertEquals(
      clong1.as[Long],
      clong2.flatMap(_.as[Long])
    )
  }

  test("demo 2") {
    val clong =
      summon[Platform] match
        case given (Platform.LinuxX64.type |
              Platform.MacOSX64.type) =>
          CLong.certain(5L)
        case _ => CLong(5)

    assertEquals(
      clong.as[Long],
      Some(5L)
    )
  }

  test("demo 3") {
    val clong =
      summon[Platform] match
        case given Platform.LinuxX64.type =>
          CLong.certain(5L)
        case _ => CLong(5)

    assertEquals(
      clong.as[Long],
      Some(5L)
    )
  }
