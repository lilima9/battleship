class Game(
    private val player1: Player,
    private val player2: Player
) {
    fun play(scanner: InputTaker): Player {
        val player2BattleField = player2.battleField
        val player1BattleField = player1.battleField
        while (player1BattleField.hasFloatingShips() && player2BattleField.hasFloatingShips()) {
            do {
                print("Player 1: Enter target to hit (0 0) : ")
                val (player1TargetXCoordinate, player1TargetYCoordinate) = enterTarget(scanner)
                val shotStatus = player2BattleField.hit(player1TargetXCoordinate, player1TargetYCoordinate)
                println("Shot status : $shotStatus")
            } while (shotStatus == ShotStatus.HIT && player2BattleField.hasFloatingShips())

            if(!player2BattleField.hasFloatingShips()) return player1

            do {
                print("Player 2: Enter target to hit (0 0) : ")
                val (player2TargetXCoordinate, player2TargetYCoordinate) = enterTarget(scanner)
                val shotStatus = player1BattleField.hit(player2TargetXCoordinate, player2TargetYCoordinate)
                println("Shot status : $shotStatus")
            } while (shotStatus == ShotStatus.HIT && player1BattleField.hasFloatingShips())
        }

        return player2
    }

    private fun enterTarget(scanner: InputTaker): Pair<Int, Int> {
        val xCoordinate = scanner.input()
        val yCoordinate = scanner.input()
        return Pair(xCoordinate, yCoordinate)
    }
}
