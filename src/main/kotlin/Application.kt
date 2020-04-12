import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    print("Enter size of the battle area (m*n) : ")
    val numberOfRows = scanner.nextInt()
    val numberOfColumns = scanner.nextInt()

    val battleField1 = BattleField(numberOfRows, numberOfColumns)
    val battleField2 = BattleField(numberOfRows, numberOfColumns)
    print("Enter number of ships : ")
    val numberOfShips = scanner.nextInt()

    for (index in 0 until numberOfShips) {
        print("Enter dimension for ship ${index + 1} (a*b) : ")
        val nthShipADimension = scanner.nextInt()
        val nthShipBDimension = scanner.nextInt()
        battleField1.placeShip(Ship(nthShipADimension, nthShipBDimension))
        battleField2.placeShip(Ship(nthShipADimension, nthShipBDimension))
    }
    battleField1.ships.forEach {
        println("BattleField1 Coordinates : ${it.xCoordinateOnBoard} ${it.yCoordinateOnBoard} ${it.direction}")
    }
    battleField2.ships.forEach {
        println("BattleField2 Coordinates : ${it.xCoordinateOnBoard} ${it.yCoordinateOnBoard} ${it.direction}")
    }

    while (battleField1.hasFloatingShips() && battleField2.hasFloatingShips()) {
        do {
            print("Player 1: Enter target to hit (0 0) : ")
            val player1TargetXCoordinate = scanner.nextInt()
            val player1TargetYCoordinate = scanner.nextInt()
            val shotStatus = battleField2.fireShot(player1TargetXCoordinate, player1TargetYCoordinate)
            println("Shot status : $shotStatus")
        } while (shotStatus == ShotStatus.HIT && battleField2.hasFloatingShips())

        do {
            print("Player 2: Enter target to hit (0 0) : ")
            val player2TargetXCoordinate = scanner.nextInt()
            val player2TargetYCoordinate = scanner.nextInt()
            val shotStatus = battleField1.fireShot(player2TargetXCoordinate, player2TargetYCoordinate)
            println("Shot status : $shotStatus")
        } while (shotStatus == ShotStatus.HIT && battleField1.hasFloatingShips())
    }

    if (battleField1.hasFloatingShips())
        println("Player 1 Wins!!!!!!!!!!")
    else println("Player 2 Wins!!!!!!!!!!")
}
