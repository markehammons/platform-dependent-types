package pdts

class PlatformDependentTypeDemonstration
    extends munit.FunSuite:
  val platform: Platform = WinX64

  test("demo 1") {
    val c: Platform#CLong =
      platform.clong(5)
    assertEquals(
      c,
      platform.clong(5)
    )
  }

  test("demo 2") {
    val d: Option[
      Platform#CLong
    ] = platform.clong(5L)
    assertEquals(
      d,
      platform.clong(5L)
    )
    assert(d.isEmpty)
  }

  test("demo 3") {
    val e: Platform#CLong =
      platform match
        case w: WinX64.type =>
          w.clong(5L.toInt)
        case l: LinuxX64.type =>
          l.clongCertain(5L)
        case m: MacOSX64.type =>
          m.clongCertain(5L)
    assertEquals(
      e,
      platform.clong(5)
    )
  }

  test("demo 4") {
    val x = platform.clong(5)
    val y = platform.clong(1)

    assertEquals(
      platform.clongIntegral
        .plus(x, y),
      platform.clong(6)
    )
  }
