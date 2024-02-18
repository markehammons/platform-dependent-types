package op1

class BoundaryIssuesDemonstration
    extends munit.FunSuite:
  val x: Long = Int.MaxValue
  val y: Int = Int.MaxValue

  test("addition demo") {
    assertEquals(
      (x + x).toInt,
      y + y
    )
  }

  test("comparison demo".fail) {
    assertEquals(
      x + x < x,
      y + y < y
    )
  }

  test("division demo 1".fail) {
    assertEquals(
      ((x + x) / 5).toInt,
      (y + y) / 5
    )
  }

  test("division demo 2") {
    assertEquals(
      ((x + x).toInt / 5).toLong.toInt,
      (y + y) / 5
    )
  }
