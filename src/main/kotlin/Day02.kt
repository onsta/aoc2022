enum class RPS(val score: Int) {
    ROCK(1),
    PAPER(2),
    SCISSORS(3);
    companion object{
        fun fromLetter1(letter: Char) = when(letter) {
            'X' -> RPS.ROCK
            'A' -> RPS.ROCK
            'Y' -> RPS.PAPER
            'B' -> RPS.PAPER
            'Z' -> RPS.SCISSORS
            'C' -> RPS.SCISSORS
            else -> {
                throw IllegalStateException("Invalid RPS letter $letter")
            }
        }

        fun fromLetter(letter: Char) = when(letter) {
            'A' -> RPS.ROCK
            'B' -> RPS.PAPER
            'C' -> RPS.SCISSORS
            else -> {
                throw IllegalStateException("Invalid RPS letter $letter")
            }
        }

        fun fromGameOutcome(player1: RPS, gameOutcome: GameOutcome) =
            when {
                gameOutcome == GameOutcome.DRAW -> player1
                gameOutcome == GameOutcome.WIN && player1 == RPS.PAPER -> RPS.SCISSORS
                gameOutcome == GameOutcome.WIN && player1 == RPS.SCISSORS -> RPS.ROCK
                gameOutcome == GameOutcome.WIN && player1 == RPS.ROCK -> RPS.PAPER
                gameOutcome == GameOutcome.LOST && player1 == RPS.ROCK -> RPS.SCISSORS
                gameOutcome == GameOutcome.LOST && player1 == RPS.PAPER -> RPS.ROCK
                gameOutcome == GameOutcome.LOST && player1 == RPS.SCISSORS -> RPS.PAPER
                else -> {
                    throw IllegalStateException("Invalid game outcome $player1 and $gameOutcome")
                }
            }
    }
}

enum class GameOutcome(val score: Int) {
    WIN(6),
    DRAW(3),
    LOST(0);

    companion object {
        fun fromLetter(letter: Char) = when(letter) {
            'X' -> LOST
            'Y' -> DRAW
            'Z' -> WIN
            else -> {
                throw IllegalStateException("Invalid RPS letter $letter")
            }
        }
        private fun getOutcome(you: RPS, opponent: RPS): GameOutcome =
            when {
                you == opponent -> DRAW
                you == RPS.ROCK && opponent == RPS.PAPER -> LOST
                you == RPS.ROCK && opponent == RPS.SCISSORS -> WIN
                you == RPS.PAPER && opponent == RPS.ROCK -> WIN
                you == RPS.PAPER && opponent == RPS.SCISSORS -> LOST
                you == RPS.SCISSORS && opponent == RPS.ROCK -> LOST
                you == RPS.SCISSORS && opponent == RPS.PAPER -> WIN
                else -> {
                    throw IllegalStateException("Invalid game outcome$you $opponent")
                }
            }


        fun getRoundScore(you: RPS, opponent: RPS): Int {
            return getOutcome(you, opponent).score + you.score
        }
    }
}
fun main() {
    fun part1(input: List<String>): Int {
        return input.sumOf {
            GameOutcome.getRoundScore(
                RPS.fromLetter1(it.last()),
                RPS.fromLetter1(it.first()),
            )
        }
    }

    fun part2(input: List<String>): Int {
        return input.sumOf {
            GameOutcome.getRoundScore(
                RPS.fromGameOutcome(
                    RPS.fromLetter(it.first()),
                    GameOutcome.fromLetter(it.last())
                ),
                RPS.fromLetter(it.first()),
            )
        }
    }

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
