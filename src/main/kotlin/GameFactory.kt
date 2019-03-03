import kotlin.random.Random

class GameFactory(private val random: Random.Default) {
    fun create(playerNames: List<String>) = Game(playerNames, random)
}