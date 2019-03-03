class UI(private val console: Console) {
    fun getPlayerNames(): List<String> {
        console.println("이름을 입력하시오.")
        return console.getInput().split(" ")
    }

    fun getTurns(): Int {
        console.println("Turn 수:")
        while (true) {
            try {
                return Integer.parseInt(console.getInput())
            } catch (_: Exception) {
                console.println("잘못된 입력입니다. 숫자만 입력해주세요. Turn 수:")
            }
        }
    }

    fun printPlayers(players: List<Player>) {
        console.println(players.joinToString(separator = "\n") {
            "${it.name}:${"-".repeat(it.score)}"
        })
    }

    fun printWinner(winner: Player) {
        console.println("우승자는 ${winner.name} 입니다.")
    }

    fun printTurn(turn: Int) {
        console.println("-- $turn 번째 턴 --")
    }
}