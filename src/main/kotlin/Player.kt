class Player(
    val battleField: BattleField
) {
    fun enterTarget(scanner: InputTaker): Point {
        return Point(scanner.input(), scanner.input())
    }
}
