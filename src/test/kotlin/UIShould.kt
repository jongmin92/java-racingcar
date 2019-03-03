import io.mockk.*
import io.mockk.impl.annotations.MockK
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class UIShould {

    @MockK
    lateinit var console: Console
    private lateinit var ui: UI

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        ui = UI(console)
    }

    @Test
    fun `get players successfully, when console gets the valid user's input`() {
        // GIVEN
        every { console.getInput() } returns "a b c"

        // WHEN
        val actual = ui.getPlayerNames()

        // THEN
        verifyOrder {
            console.println("이름을 입력하시오.")
            console.getInput()
        }
        assertEquals(listOf("a", "b", "c"), actual)
    }

    @Test
    fun `get turns successfully, when console gets Int as the user's input`() {
        // GIVEN
        every { console.getInput() } returns "1"
        val ui = UI(console)

        // WHEN
        val actual = ui.getTurns()

        // THEN
        verifyOrder {
            console.println("Turn 수:")
            console.getInput()
        }
        assertEquals(1, actual)
    }

    @Test
    fun `ask for turns from user again, when console gets the invalid user's input`() {
        // GIVEN
        every { console.getInput() } returnsMany listOf(
            "aaa" // invalid input
            , "1"
        )

        // WHEN
        val actual = ui.getTurns()

        // THEN
        verifyOrder {
            console.println("Turn 수:")
            console.getInput()
            console.println("잘못된 입력입니다. 숫자만 입력해주세요. Turn 수:")
            console.getInput()
        }
        assertEquals(1, actual)
    }

    @Test
    fun `print current game's state, when game is playing`() {
        // GIVEN
        val players = listOf(Player("a", 1), Player("b", 2))

        // WHEN
        ui.printPlayers(players)

        // THEN
        verify {
            console.println("a:-\nb:--")
        }
    }

    @Test
    fun `print current game's winner, when game is finished`() {
        // GIVEN
        val player = Player("a", 1)

        // WHEN
        ui.printWinner(player)

        // THEN
        verify {
            console.println("우승자는 a 입니다.")
        }
    }

    @Test
    fun `print current turn, when game is playing`() {
        // GIVEN
        val turn = 3

        // WHEN
        ui.printTurn(turn)

        // THEN
        verify {
            console.println("-- 3 번째 턴 --")
        }
    }
}