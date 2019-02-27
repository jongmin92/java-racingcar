import kotlin.random.Random

class Game(playerNames: List<String>, private val random: Random) {

    var players = playerNames.map { Player(it, 0) }
        private set

    fun play() {
        players = players.map { it.copy(score = it.score + random.nextInt(5)) }
    }

    fun winner(): Player = players.maxBy { it.score }!!
}

data class Player(val name: String, val score: Int)