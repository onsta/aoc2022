fun main() {
    fun part1(input: List<String>): String {
        val crates = input
            .takeWhile { it.isNotEmpty() }
            .dropLast(1)
            .map { line ->
                Regex("(\\s{4}|[A-Z])").findAll(line)
                    .map { it.value }
                    .map {
                        it.ifBlank {
                            null
                        }
                    }
                    .toList()
            }
            .flatMap {
                it.mapIndexed { i, v ->
                    if (v == null) {
                        null
                    } else {
                        Pair(i + 1, mutableListOf(v))
                    }
                }.filterNotNull()
            }
            .foldRight(mutableMapOf<Int, MutableList<String>>()) { pair, acc ->
                acc[pair.first]?.addAll(pair.second)
                if (acc[pair.first] == null) {
                    acc[pair.first] = pair.second
                }
                acc
            }.also {
                println(it)
            }

        val instructions = input
            .takeLastWhile { it.isNotEmpty() }
            .map { line ->
                Regex("(\\d+)")
                    .findAll(line)
                    .map { it.value.toInt() }
                    .toList()
            }

        instructions.forEach {
            val (times, from, to) = it
            repeat(times) {
                val crate = crates[from]?.takeLast(1)?.single()
                crate?.let { c ->
                    crates[from] = crates[from]!!.dropLast(1).toMutableList()
                    crates[to] = (crates[to]!! + c).toMutableList()
                }
            }
        }

        return crates
            .values
            .map { it.takeLast(1) }
            .reversed()
            .joinToString("") { it.single() }
    }

    fun part2(input: List<String>): String {
        val crates = input
            .takeWhile { it.isNotEmpty() }
            .dropLast(1)
            .map { line ->
                Regex("(\\s{4}|[A-Z])").findAll(line)
                    .map { it.value }
                    .map {
                        it.ifBlank {
                            null
                        }
                    }
                    .toList()
            }
            .flatMap {
                it.mapIndexed { i, v ->
                    if (v == null) {
                        null
                    } else {
                        Pair(i + 1, mutableListOf(v))
                    }
                }.filterNotNull()
            }
            .foldRight(mutableMapOf<Int, MutableList<String>>()) { pair, acc ->
                acc[pair.first]?.addAll(pair.second)
                if (acc[pair.first] == null) {
                    acc[pair.first] = pair.second
                }
                acc
            }.also {
                println(it)
            }

        val instructions = input
            .takeLastWhile { it.isNotEmpty() }
            .map { line ->
                Regex("(\\d+)")
                    .findAll(line)
                    .map { it.value.toInt() }
                    .toList()
            }

        instructions.forEach {
            val (noOfCrates, from, to) = it
            val crate = crates[from]?.takeLast(noOfCrates)
            crate?.let {c ->
                crates[from] = crates[from]!!.dropLast(noOfCrates).toMutableList()
                crates[to] = (crates[to]!! + c).toMutableList()
            }

        }

        return crates
            .values
            .map { it.takeLast(1) }
            .reversed()
            .joinToString("") { it.single() }
    }

    val input = readInput("Day05")
    println(part1(input))
    println(part2(input))
}
