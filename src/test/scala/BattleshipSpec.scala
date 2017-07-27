import Battleship._
import org.scalatest._

class BattleshipSpec extends FlatSpec with Matchers {
  "Battleship" should "get correct answers" in {
     solution(4, "1B 2C,2D 4D", "2B 2D 3D 4D 4A") should be ("1,1")
     solution(12, "1A 2A,12A 12A", "12A") should be ("1,0")
     solution(12, "1A 2B,5D 7D", "3A 7C 2E 4D 8C") should be ("0,0")
   }

}
