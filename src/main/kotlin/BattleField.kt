class BattleField(
    private val numberOfRows: Int,
    private val numberOfColumns: Int
) {
    var ships: MutableList<Ship> = emptyList<Ship>().toMutableList()
        private set
    var shipCoordinates: MutableList<Pair<Point, Ship>> = emptyList<Pair<Point, Ship>>().toMutableList()
        private set

    fun placeShip(ship: Ship, location: Point) {
        require(location.xCoordinate <= numberOfRows - 1)
        require(location.yCoordinate <= numberOfColumns - 1)

        shipCoordinates.add(Pair(location, ship))
        ships.add(ship)
    }

    fun hasFloatingShips(): Boolean {
        return ships.any { it.isFloating }
    }

    fun hit(location: Point): ShotStatus {
        val ship = shipCoordinates.firstOrNull {
            location.xCoordinate in (it.first.xCoordinate until it.first.xCoordinate + it.second.length) &&
                    location.yCoordinate in (it.first.yCoordinate until it.first.yCoordinate + it.second.breadth)
        }
        ship?.second?.let {
            it.increaseHitCount()
            return ShotStatus.HIT
        }
        return ShotStatus.MISS
    }
}