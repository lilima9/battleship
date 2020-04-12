import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class BattleFieldTest {
    @Test
    fun `should add ship to the field`() {
        val battleField = BattleField(5, 5)
        val ship = Ship(2, 2)

        battleField.placeShip(ship)

        assertThat(battleField.ships).contains(ship)
    }

    @Test
    fun `should assign location to ship within the board`() {
        val battleField = BattleField(5, 5)
        val ship = Ship(2, 2)

        battleField.placeShip(ship)

        assertThat(battleField.ships[0].xCoordinateOnBoard).isLessThan(5)
        assertThat(battleField.ships[0].yCoordinateOnBoard).isLessThan(5)
    }
}