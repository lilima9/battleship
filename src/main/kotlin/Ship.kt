class Ship(
    private val length: Int,
    private val breadth: Int
) {
    var locationOnBoard: Point = Point(0, 0)
        private set
    var hitCount: Int = 0
        private set
    val isFloating: Boolean
        get() {
            return length * breadth > hitCount
        }

    fun assignLocationOnBoard(location: Point) {
        this.locationOnBoard = location
    }

    fun isInRange(location: Point): Boolean {
        return location.xCoordinate in (locationOnBoard.xCoordinate until locationOnBoard.xCoordinate + length) &&
                location.yCoordinate in (locationOnBoard.yCoordinate until locationOnBoard.yCoordinate + breadth)
    }

    fun increaseHitCount() {
        hitCount++
    }
}
