import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BattleFieldTest {
    @Test
    fun `placeShip should add ship to the field`() {
        val battleField = BattleField(5, 5)
        val ship = Ship(2, 2)

        battleField.placeShip(ship, Point(0, 0))

        assertThat(battleField.ships).contains(ship)
    }

    @Test
    fun `placeShip should assign location to ship within the board`() {
        val battleField = BattleField(5, 5)
        val ship = Ship(2, 2)

        battleField.placeShip(ship, Point(0, 0))

        assertThat(battleField.ships[0].locationOnBoard).isEqualTo(Point(0, 0))
    }

    @Test
    fun `hasFloatingShips should return true when any floating ship is present`() {
        val battleField = BattleField(5, 5)
        val ship = Ship(2, 2)

        battleField.placeShip(ship, Point(0, 0))

        assertThat(battleField.hasFloatingShips()).isTrue()
    }

    @Test
    fun `fireShot should return Hit when the shot hits a ship`() {
        val battleField = BattleField(5, 5)
        val ship = Ship(2, 2)

        battleField.placeShip(ship, Point(0, 0))

        val xCoordinateOnBoard = ship.locationOnBoard.xCoordinate
        val yCoordinateOnBoard = ship.locationOnBoard.yCoordinate
        assertThat(
            battleField.hit(
                Point(
                    xCoordinateOnBoard + 1,
                    yCoordinateOnBoard
                )
            )
        ).isEqualTo(ShotStatus.HIT)
    }

    @Test
    fun `fireShot should return Miss when the shot does not hit a ship`() {
        val battleField = BattleField(5, 5)
        val ship = Ship(1, 2)

        battleField.placeShip(ship, Point(0, 0))

        val xCoordinateOnBoard = ship.locationOnBoard.xCoordinate
        val yCoordinateOnBoard = ship.locationOnBoard.yCoordinate
        assertThat(
            battleField.hit(
                Point(
                    xCoordinateOnBoard + 2,
                    yCoordinateOnBoard
                )
            )
        ).isEqualTo(ShotStatus.MISS)
    }
}