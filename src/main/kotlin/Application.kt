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
        val ship = Ship(nthShipADimension, nthShipBDimension)
        battleField1.placeShip(ship)
        battleField2.placeShip(ship)
    }

    val player1 = Player(battleField1)
    val player2 = Player(battleField2)


}