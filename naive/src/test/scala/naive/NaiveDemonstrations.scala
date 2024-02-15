package naive

class NaiveDemonstrations
    extends munit.FunSuite:
  test("demo 1") {
    val clong1 = CLong(4L)
    val clong2 = CLong(2)

    val result = (
      clong1.data,
      clong2.data
    ) match
      case (i: Int, j: Int) =>
        CLong(i + j)
      case (i: Long, j: Long) =>
        CLong(i + j)
      case (i: Int, j: Long) =>
        CLong(i.toLong + j)
      case (i: Long, j: Int) =>
        CLong(i + j.toLong)

    assertEquals(
      result.data,
      CLong(6L).data
    )
  }
