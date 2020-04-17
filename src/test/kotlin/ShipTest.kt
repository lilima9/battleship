import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ShipTest {
    @Test
    fun `assignLocationOnBoard should assign x and y coordinate of ship in battlefield`() {
        val ship = Ship(2, 3)

        ship.assignLocationOnBoard(0, 1)

        assertEquals(0, ship.xCoordinateOnBoard)
        assertEquals(1, ship.yCoordinateOnBoard)
    }

    @Test
    fun `isInRange should return true when the ship is in the range of given coordinates`() {
        val ship = Ship(2, 3)
        ship.assignLocationOnBoard(0, 1)

        assertThat(ship.isInRange(0, 1)).isTrue()
    }

    @Test
    fun `isInRange should return false when the ship is not in the range of given coordinates`() {
        val ship = Ship(2, 3)
        ship.assignLocationOnBoard(0, 1)

        assertThat(ship.isInRange(3, 1)).isFalse()
    }

    @Test
    fun `updateHitStatus should update the hit count of the ship`() {
        val ship = Ship(2, 3)
        ship.assignLocationOnBoard(0, 1)

        ship.increaseHitCount()

        assertThat(ship.hitCount).isEqualTo(1)
    }

    @Test
    fun `isFloating should be true when the ship is not completely hit`() {
        val ship = Ship(1, 2)
        ship.assignLocationOnBoard(0, 1)

        ship.increaseHitCount()

        assertThat(ship.isFloating).isTrue()
    }

    @Test
    fun `isFloating should be false when the ship is completely hit`() {
        val ship = Ship(1, 1)
        ship.assignLocationOnBoard(0, 1)

        ship.increaseHitCount()

        assertThat(ship.isFloating).isFalse()
    }

    @Test
    fun `willClashPositionWith should be false when the ship will clash with given ship's position`() {
        val ship = Ship(1, 1)
        ship.assignLocationOnBoard(0, 1)

        ship.increaseHitCount()

        assertThat(ship.isFloating).isFalse()
    }
}
