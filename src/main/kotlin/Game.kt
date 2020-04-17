class Game(
    private val player1: Player,
    private val player2: Player
) {
    fun play(scanner: InputTaker): Player {
        val player1BattleField = player1.battleField
        val player2BattleField = player2.battleField

        while (player1BattleField.hasFloatingShips() && player2BattleField.hasFloatingShips()) {
            playerTurn(player1, scanner, player2BattleField)
            if (!player2BattleField.hasFloatingShips()) return player1
            playerTurn(player2, scanner, player1BattleField)
        }

        return player2
    }

    private fun playerTurn(player: Player, scanner: InputTaker, oppositionBattleField: BattleField) {
        if (player == player1) println("Player 1") else println("Player 2")
        do {
            print("Enter target to hit (0 0) : ")
            val location = player.enterTarget(scanner)
            val shotStatus = oppositionBattleField.hit(location)
            println("Shot status : $shotStatus")
        } while (shotStatus == ShotStatus.HIT && oppositionBattleField.hasFloatingShips())
    }
}
