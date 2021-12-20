class City(val name: String) {
    var population: Int = 0
        set(value) {
            field = when {
                value > 50_000_000 -> 50_000_000
                value < 0 -> 0
                else -> value
            }
        }
}
