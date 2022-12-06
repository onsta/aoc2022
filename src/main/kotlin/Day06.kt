fun main() {
    fun part1(input: List<String>): Int {
        input
            .single()
            .toList()
            .windowed(4, 1)
            .forEachIndexed { i, l ->
                if(l.distinct().size == 4) {
                    return i + 4
                }
            }
        return 0
    }

    fun part2(input: List<String>): Int {
        input
            .single()
            .toList()
            .windowed(14, 1)
            .forEachIndexed { i, l ->
                if(l.distinct().size == 14) {
                    return i + 14
                }
            }
        return 0
    }

    val input = readInput("Day06")
    println(part1(input))
    println(part2(input))
}
