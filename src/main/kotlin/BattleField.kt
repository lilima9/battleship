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
                (0 until numberOfColumns - ship.length).random()
            }
            Direction.TB -> {
                (0 until (numberOfRows - ship.length)).random()
            }
        }
    }

    private fun yCoordinateForShip(ship: Ship): Int {
        return when (ship.direction) {
            Direction.LR -> {
                (0 until (numberOfRows - ship.breadth)).random()
            }
            Direction.TB -> {
                (0 until (numberOfColumns - ship.breadth)).random()
            }
        }
    }

    fun hasFloatingShips(): Boolean {
        return ships.any {
            it.isFloating
        }
    }

    fun fireShot(xCoordinate: Int, yCoordinate: Int): ShotStatus {
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