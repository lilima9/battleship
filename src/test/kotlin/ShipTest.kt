import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ShipTest {
    @Test
    fun `updateHitStatus should update the hit count of the ship`() {
        val ship = Ship(2, 3)

        ship.increaseHitCount()

        assertThat(ship.hitCount).isEqualTo(1)
    }

    @Test
    fun `isFloating should be true when the ship is not completely hit`() {
        val ship = Ship(1, 2)

        ship.increaseHitCount()

        assertThat(ship.isFloating).isTrue()
    }

    @Test
    fun `isFloating should be false when the ship is completely hit`() {
        val ship = Ship(1, 1)

        ship.increaseHitCount()

        assertThat(ship.isFloating).isFalse()
    }
}
