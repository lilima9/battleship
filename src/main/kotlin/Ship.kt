class Ship(val length: Int, val breadth: Int) {
    var xCoordinateOnBoard: Int = 0
    var yCoordinateOnBoard: Int = 0
    val direction = Direction.values().random()

    fun assignLocationOnBoard(xCoordinate: Int, yCoordinate: Int) {
        this.xCoordinateOnBoard = xCoordinate
        this.yCoordinateOnBoard = yCoordinate
    }
}
