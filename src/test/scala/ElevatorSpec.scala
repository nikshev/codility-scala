import Elevator._
import org.scalatest._

class ElevatorSpec extends FlatSpec with Matchers {
  "Lift" should "get correct answers" in {
    var A = Array[Int](60, 80, 40)
    var B = Array[Int](2, 3, 5)
    var M = 5
    var X = 2
    var Y = 200
    solution(A, B, M, X, Y) should be (5)

    A = Array[Int](40, 40, 100, 80, 20)
    B = Array[Int](3, 3, 2, 2, 3)
    M = 3
    X = 5
    Y = 200
    solution(A, B, M, X, Y) should be (6)

    A = Array[Int](40, 40, 100, 200, 20)
    B = Array[Int](3, 3, 2, 2, 3)
    M = 3
    X = 5
    Y = 200
    solution(A, B, M, X, Y) should be (6)

    A = Array[Int](40, 40, 100, 200, 20)
    B = Array[Int](3, 3, 2, 2, 3)
    M = 3
    X = 1
    Y = 200
    solution(A, B, M, X, Y) should be (10)
  }

}
