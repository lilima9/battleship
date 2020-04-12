import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ShipTest {
    @Test
    fun `should assign x and y coordinate of ship in battlefield`() {
        val ship = Ship(2, 3)

        ship.assignLocationOnBoard(0, 1)

        assertEquals(0, ship.xCoordinateOnBoard)
        assertEquals(1, ship.yCoordinateOnBoard)
    }
}