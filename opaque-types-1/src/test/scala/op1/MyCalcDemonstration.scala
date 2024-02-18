package op1

class MyCalcDemonstration
    extends munit.FunSuite:
  def myFun[A](using
      mc: MyCalc[A]
  )(b: mc.B): mc.B = b

  test("compiles") {
    assertNoDiff(
      compileErrors(
        "val f: Float = myFun[Int](5f)"
      ),
      ""
    )
  }
