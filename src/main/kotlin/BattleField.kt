class BattleField(
    private val numberOfRows: Int,
    private val numberOfColumns: Int
) {
    var ships: MutableList<Ship> = emptyList<Ship>().toMutableList()
        private set

    fun placeShip(ship: Ship, location: Point) {
        require(location.xCoordinate <= numberOfRows - 1)
        require(location.yCoordinate <= numberOfColumns - 1)
        ship.assignLocationOnBoard(location)

        ships.add(ship)
    }

    fun hasFloatingShips(): Boolean {
        return ships.any {
            it.isFloating
        }
    }

    fun hit(location: Point): ShotStatus {
        val ship = ships.firstOrNull {
            it.isInRange(location)
        }
        ship?.let {
            it.increaseHitCount()
            return ShotStatus.HIT
        }
        return ShotStatus.MISS
    }
}