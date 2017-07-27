/**
  * Object Elevator
  * Count stops needed for queue
  */
object Elevator {
  /**
    * Solution for stops count
    * @param a - passngers weight
    * @param b - needed floors
    * @param m - floor maximum
    * @param x - max passengers count in elevator
    * @param y - max passengers weight in elevator
    * @return total stops
    */
  def solution(a: Array[Int], b: Array[Int], m: Int, x: Int, y: Int): Int = {
    var elevatorStops:Int = 0
    var totalWeight:Int =0
    var maxPersons:Int =0
    var floors:List[Int] = List()
    var currPerson = 0
    var elevatorMove = false

    while (currPerson < a.length) {
      if ((totalWeight + a(currPerson)) <= y && (maxPersons + 1) <= x) {
        totalWeight + a(currPerson)
        maxPersons += 1
        floors +:= b(currPerson)
        if (currPerson == a.length - 1)
          elevatorMove = true
        currPerson += 1
      } else {
        elevatorMove = true
      }

      if (elevatorMove) {
        elevatorStops += floors.length+1
        floors = List()
        maxPersons = 0
        totalWeight = 0
        elevatorMove = false
      }
    }

    elevatorStops
  }
}