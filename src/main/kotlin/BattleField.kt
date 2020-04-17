class BattleField(
    private val numberOfRows: Int,
    private val numberOfColumns: Int
) {
    var ships: MutableList<Ship> = emptyList<Ship>().toMutableList()
        private set

    fun placeShip(ship: Ship, xCoordinateForShip: Int, yCoordinateForShip: Int) {
        require(xCoordinateForShip <= numberOfRows - 1)
        require(yCoordinateForShip <= numberOfColumns - 1)
        ship.assignLocationOnBoard(xCoordinateForShip, yCoordinateForShip)

        ships.add(ship)
    }

    fun hasFloatingShips(): Boolean {
        return ships.any {
            it.isFloating
        }
    }

    fun hit(xCoordinate: Int, yCoordinate: Int): ShotStatus {
        val ship = ships.firstOrNull {
            it.isInRange(xCoordinate, yCoordinate)
        }
        ship?.let {
            it.increaseHitCount()
            return ShotStatus.HIT
        }
        return ShotStatus.MISS
    }
}