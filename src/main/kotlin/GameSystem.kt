import kotlin.random.Random

class GameSystem(private val ui: UI, private val gameFactory: GameFactory) {
    fun start() {
        val playerNames = ui.getPlayerNames()
        val turns = ui.getTurns()

        val game = gameFactory.create(playerNames)
        repeat(turns) {
            ui.printTurn(it + 1)
            game.play()
            ui.printPlayers(game.players)
        }
        ui.printWinner(game.winner())
    }
}

fun main() {
    GameSystem(UI(Console()), GameFactory(Random)).start()
}