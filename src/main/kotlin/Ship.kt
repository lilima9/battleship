class Ship(val length: Int, val breadth: Int) {
    var xCoordinateOnBoard: Int = 0
        private set
    var yCoordinateOnBoard: Int = 0
        private set
    var hitCount: Int = 0
        private set
    val isFloating: Boolean
        get() {
            return length * breadth > hitCount
        }

    fun assignLocationOnBoard(xCoordinate: Int, yCoordinate: Int) {
        this.xCoordinateOnBoard = xCoordinate
        this.yCoordinateOnBoard = yCoordinate
    }

    fun isInRange(xCoordinate: Int, yCoordinate: Int): Boolean {
        return xCoordinate in (xCoordinateOnBoard until xCoordinateOnBoard + length) &&
                yCoordinate in (yCoordinateOnBoard until xCoordinateOnBoard + breadth)
    }

    fun increaseHitCount() {
        hitCount++
    }
}
