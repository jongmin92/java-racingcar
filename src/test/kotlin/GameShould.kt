import io.mockk.every
import io.mockk.spyk
import org.junit.Test
import kotlin.random.Random
import kotlin.test.assertEquals

class GameShould {

    @Test
    fun `play and get winner`() {
        // GIVEN
        val random = spyk(Random.Default)
        every { random.nextInt(any()) } returnsMany listOf(1, 2)
        val game = Game(listOf("a", "b"), random)

        // WHEN
        game.play()

        // THEN
        assertEquals(listOf(Player("a", 1), Player("b", 2)), game.players)
        assertEquals(Player("b", 2), game.winner())
    }
}
