class Player(
    val battleField: BattleField
) {
    fun enterTarget(scanner: InputTaker): Pair<Int, Int> {
        return Pair(scanner.input(), scanner.input())
    }
}
