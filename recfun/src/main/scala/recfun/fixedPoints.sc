object exercise {
  val tolerance = 0.0001

  def isCloseEnough(x: Double, y: Double) =
    math.abs((x - y) / x) / x < tolerance

  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def iterate(guess: Double): Double = {
      println("guess = " + guess)
      val next = f(guess)
      if (isCloseEnough(guess, next)) guess
      else iterate(next)
    }
    iterate(firstGuess)
  }

  fixedPoint(x => 1 + x / 2)(1)

  def averageDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2

  //def sqrt(x: Int) = fixedPoint(y => (y + x / y) / 2)(x)
  def sqrt(x: Int) = fixedPoint(averageDamp(y => x / y))(1)

  sqrt(2)
}