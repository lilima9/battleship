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
        val location = Point(0, 0)

        battleField.placeShip(ship, location)

        assertThat(battleField.shipCoordinates.first().first).isEqualTo(location)
        assertThat(battleField.shipCoordinates.first().second).isEqualTo(ship)
    }

    @Test
    fun `hasFloatingShips should return true when any floating ship is present`() {
        val battleField = BattleField(5, 5)
        val ship = Ship(2, 2)

        battleField.placeShip(ship, Point(0, 0))

        assertThat(battleField.hasFloatingShips()).isTrue()
    }

    @Test
    fun `hit should return Hit when the shot hits a ship`() {
        val battleField = BattleField(5, 5)
        val ship = Ship(2, 2)

        battleField.placeShip(ship, Point(0, 0))

        assertThat(
            battleField.hit(
                Point(
                    1,
                    1
                )
            )
        ).isEqualTo(ShotStatus.HIT)
    }

    @Test
    fun `hit should return Miss when the shot does not hit a ship`() {
        val battleField = BattleField(5, 5)
        val ship = Ship(1, 2)

        battleField.placeShip(ship, Point(0, 0))

        assertThat(
            battleField.hit(
                Point(
                    2,
                    1
                )
            )
        ).isEqualTo(ShotStatus.MISS)
    }
}