import scala.collection.mutable.ListBuffer

/**
  * Point class (work with points get coordinates and etc)
  * @param coord
  */
class Point(val coord: String) {
  var x = 0
  var y = 0

  x = coord.toUpperCase.charAt(1) - 'A'
  y = coord.charAt(0) - '1'

  def getX: Int = x

  def getY: Int = y

  def greaterOrEqual(other: Point): Boolean = x >= other.x && y >= other.y

  override def toString: String = "(" + x + ", " + y + ")"
}

/**
  * Ship class (create ship, place it, get size, get hits)
  * @param topLeft:Point
  * @param bottomRight:Point
  */
class Ship(var topLeft: Point, var bottomRight: Point) {
  def getTopLeft: Point = topLeft

  def getBottomRight: Point = bottomRight

  def getSize: Int = (Math.abs(topLeft.getX - bottomRight.getX) + 1) * (Math.abs(topLeft.getY - bottomRight.getY) + 1)

  override def toString: String = "(" + topLeft + ", " + bottomRight + ")"

  def getHits(shots: List[Point]): Int = {
    var hits = 0
    for (shot <- shots) {
      if (shot.greaterOrEqual(topLeft) && bottomRight.greaterOrEqual(shot))
        hits += 1
    }
    hits
  }
}

/**
  * Battleship object
  */
object Battleship {

  /**
    * Parse hits (get coordinates and return hits coordinates)
    * @param hits: String
    * @return List
    */
  def parseHits(hits: String): List[Point] = {
    var hitsList: ListBuffer[Point] = new ListBuffer[Point]()
    val coords = hits.split(" ")
    for (coord <- coords) {
      hitsList +:= new Point(coord)
    }
    hitsList.toList
  }

  /**
    * Parse ships (get ships coordinates and return it)
    * @param ships: String
    * @return List
    */
  def parseShips(ships: String): List[Ship] = {
    var shipsList : ListBuffer[Ship] = new ListBuffer[Ship]()
    val shipsCoords = ships.split(",")
    for (shipCoord <- shipsCoords) {
      val coords = shipCoord.split(" ")
      val ship = new Ship(new Point(coords(0)),new Point(coords(1)))
      shipsList += ship
    }
    shipsList.toList
  }

  /**
    * Solution for battleship
    * @param n - size (no need because we use list)
    * @param s - ship coordinates
    * @param t - hits coordinates
    * @return String
    */
  def solution(n: Int, s: String, t: String): String = {
    val ships = parseShips(s)
    val hits = parseHits(t)
    var touched = 0
    var sunken = 0
    for (current <- ships) {
      val touching = current.getHits(hits)
      if (touching > 0)
        if (touching == current.getSize)
          sunken += 1
        else touched += 1
    }

    "" + sunken + "," + touched
  }

}
