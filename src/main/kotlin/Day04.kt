fun IntRange.containedInOther(other: IntRange): Boolean =
    if(other.first in this && other.last in this) {
        true
    } else if(this.first in other && this.last in other) {
        true
    } else {
        false
    }

fun IntRange.overlaps(other: IntRange): Boolean =
    if(other.first in this || other.last in this) {
        true
    } else if(this.first in other || this.last in other) {
        true
    } else {
        false
    }


fun main() {
    fun part1(input: List<String>): Int {
        return input
            .map { it.split(",").map {n -> n.split("-") } }
            .map {
                Pair(
                    IntRange(
                        it.first().first().toInt(),
                        it.first().last().toInt()
                    ),
                    IntRange(
                        it.last().first().toInt(),
                        it.last().last().toInt()
                    )
                )
            }
            .map {
                if(it.first.containedInOther(it.second)) 1 else 0
            }
            .sum()
    }

    fun part2(input: List<String>): Int {
        return input
            .map { it.split(",").map {n -> n.split("-") } }
            .map {
                Pair(
                    IntRange(
                        it.first().first().toInt(),
                        it.first().last().toInt()
                    ),
                    IntRange(
                        it.last().first().toInt(),
                        it.last().last().toInt()
                    )
                )
            }
            .map {
                if(it.first.overlaps(it.second)) 1 else 0
            }
            .sum()
    }

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}
