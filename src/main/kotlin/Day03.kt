fun getCode(c: Char) =
    if (c.isUpperCase()) {
        c.code - 'A'.code + 27
    } else {
        c.code - 'a'.code + 1
    }

fun main() {
    fun part1(input: List<String>): Int {
        return input
            .map {
                val half = it.length / 2
                Pair(it.take(half), it.takeLast(half))
            }
            .map {
                it.first.toSet().intersect(it.second.toSet())
            }
            .sumOf {
                getCode(it.first())
            }

    }

    fun part2(input: List<String>): Int {
         return input
            .asSequence()
            .mapIndexed { i, v -> Pair(i, v)}
            .groupBy { it.first / 3 }
            .map { it.value }
            .map { group -> group.map { pair -> pair.second.toSet()} }
            .map { it.reduce {acc, value -> acc.intersect(value) } }
            .sumOf { getCode(it.first()) }
    }

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
