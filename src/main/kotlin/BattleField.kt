class BattleField(
    private val numberOfRows: Int,
    private val numberOfColumns: Int
) {
    var ships: MutableList<Ship> = emptyList<Ship>().toMutableList()
        private set

    fun placeShip(ship: Ship) {
        val xCoordinateForShip = xCoordinateForShip(ship)
        val yCoordinateForShip = yCoordinateForShip(ship)

        ship.assignLocationOnBoard(xCoordinateForShip, yCoordinateForShip)

        ships.add(ship)
    }

    private fun xCoordinateForShip(ship: Ship): Int {
        return when (ship.direction) {
            Direction.LR -> {
                ((numberOfColumns - ship.breadth)..numberOfColumns).random()
            }
            Direction.TB -> {
                ((numberOfRows - ship.length)..numberOfRows).random()
            }
        }
    }

    private fun yCoordinateForShip(ship: Ship): Int {
        return when (ship.direction) {
            Direction.LR -> {
                ((numberOfRows - ship.length)..numberOfRows).random()
            }
            Direction.TB -> {
                ((numberOfColumns - ship.length)..numberOfColumns).random()
            }
        }
    }
}