import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    print("Enter size of the battle area (m*n) : ")
    val numberOfRows = scanner.nextInt()
    val numberOfColumns = scanner.nextInt()

    val battleField1 = BattleField(numberOfRows, numberOfColumns)
    val player1 = Player(battleField1)
    val battleField2 = BattleField(numberOfRows, numberOfColumns)
    val player2 = Player(battleField2)
    print("Enter number of ships : ")
    val numberOfShips = scanner.nextInt()

    for (index in 0 until numberOfShips) {
        print("Enter dimension for ship ${index + 1} (a*b) : ")
        val nthShipADimension = scanner.nextInt()
        val nthShipBDimension = scanner.nextInt()
        print("Enter position for ship ${index + 1} (0 0) on battlefield 1: ")
        battleField1.placeShip(Ship(nthShipADimension, nthShipBDimension), scanner.nextInt(), scanner.nextInt())
        print("Enter position for ship ${index + 1} (0 0) on battlefield 2: ")
        battleField2.placeShip(Ship(nthShipADimension, nthShipBDimension), scanner.nextInt(), scanner.nextInt())
    }
    battleField1.ships.forEach {
        println("BattleField 1 Coordinates : ${it.xCoordinateOnBoard} ${it.yCoordinateOnBoard}")
    }
    battleField2.ships.forEach {
        println("BattleField 2 Coordinates : ${it.xCoordinateOnBoard} ${it.yCoordinateOnBoard} ")
    }

    val inputter = InputTaker(scanner)
    val game = Game(player1, player2)

    val winningPlayer = game.play(inputter)

    if (winningPlayer == player1)
        println("Player 1 Wins!!!!!!!!!!")
    else println("Player 2 Wins!!!!!!!!!!")
}


