package op2

import compiletime.summonInline
import cats.Show

class InlineMatchDemonstration
    extends munit.FunSuite:
  inline def fn[A](
      a: A
  ): String = inline a match
    case v: Option[b] =>
      v.map(
        summonInline[
          Show[b]
        ].show
      ).getOrElse("empty")
    case _ =>
      summonInline[Show[A]].show(
        a
      )
  test("demo 1") {
    assertEquals(fn(5), "5")
    assertEquals(
      fn(Some("hello")),
      "hello"
    )
    assertEquals(
      fn(Option.empty[Int]),
      "empty"
    )
  }
