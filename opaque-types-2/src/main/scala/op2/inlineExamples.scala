package op2

import compiletime.summonInline

inline def inlineAdd(
    x: Int,
    y: Int
): Int = x + y

def add(x: Int, y: Int): Int =
  x + y

inline def inlineGenericAdd[A](
    x: A,
    y: A
): A =
  val integral =
    summonInline[Integral[A]]
  integral.plus(x, y)

val x = inlineAdd(5, 2)
val y = add(5, 2)
val z = inlineGenericAdd(5, 2)
//val zz = inlineGenericAdd(5f,2f)//cannot work!
