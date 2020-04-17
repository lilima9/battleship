import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GameTest {
    @Test
    fun `should return player 1 when all ships for player 2 sink`() {
        val battleField1 = BattleField(2, 2)
        battleField1.placeShip(Ship(1, 1), 0, 0)
        val battleField2 = BattleField(2, 2)
        battleField2.placeShip(Ship(1, 1), 1, 1)
        val player1 = Player(battleField = battleField1)
        val game = Game(
            player1 = player1,
            player2 = Player(battleField = battleField2)
        )

        val scanner = mockk<InputTaker>()
        every { scanner.input() } returns
                1 andThen 1 andThen 0 andThen 1
        val play = game.play(scanner)

        assertThat(play).isEqualTo(player1)
    }

    @Test
    fun `should return player 2 when all ships for player 1 sink`() {
        val battleField1 = BattleField(4, 4)
        battleField1.placeShip(Ship(1, 1), 0, 0)
        val battleField2 = BattleField(4, 4)
        battleField2.placeShip(Ship(2, 2), 1, 1)
        val player2 = Player(battleField = battleField2)
        val game = Game(
            player1 = Player(battleField = battleField1),
            player2 = player2
        )

        val scanner = mockk<InputTaker>()
        every { scanner.input() } returns
                0 andThen 1 andThen 0 andThen 0
        val play = game.play(scanner)

        assertThat(play).isEqualTo(player2)
    }

    @Test
    fun `should return player 1 when player 1 hits all ships of player 2`() {
        val battleField1 = BattleField(4, 4)
        battleField1.placeShip(Ship(1, 1), 0, 0)
        battleField1.placeShip(Ship(1, 1), 0, 1)
        val battleField2 = BattleField(4, 4)
        battleField2.placeShip(Ship(1, 1), 1, 1)
        battleField2.placeShip(Ship(1, 1), 1, 0)
        val player1 = Player(battleField = battleField1)
        val game = Game(
            player1 = player1,
            player2 = Player(battleField = battleField2)
        )

        val scanner = mockk<InputTaker>()
        every { scanner.input() } returns
                1 andThen 1 andThen 1 andThen 0
        val play = game.play(scanner)

        assertThat(play).isEqualTo(player1)
    }
}