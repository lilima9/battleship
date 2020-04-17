class Ship(
    val length: Int,
    val breadth: Int
) {
    var hitCount: Int = 0
        private set
    val isFloating: Boolean
        get() {
            return length * breadth > hitCount
        }

    fun increaseHitCount() {
        hitCount++
    }
}
