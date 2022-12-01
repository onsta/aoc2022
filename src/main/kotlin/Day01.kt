fun main() {
    fun part1(input: List<String>): Int {
        var sumOne = 0
        val sumAll: MutableList<Int> = mutableListOf()
        input.forEach {
            if(it.isBlank()) {
                sumAll.add(sumOne)
                sumOne = 0
            } else {
                sumOne += it.toInt()
            }
        }
        return sumAll.max()
    }

    fun part2(input: List<String>): Int {
        var sumOne = 0
        val sumAll: MutableList<Int> = mutableListOf()
        input.forEach {
            if(it.isBlank()) {
                sumAll.add(sumOne)
                sumOne = 0
            } else {
                sumOne += it.toInt()
            }
        }
        return sumAll.sorted().takeLast(3).sum()
    }

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
