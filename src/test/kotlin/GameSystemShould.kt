import io.mockk.every
import io.mockk.spyk
import io.mockk.verifyOrder
import org.junit.Test

import kotlin.random.Random

class GameSystemShould {

    @Test
    fun `begin and end a game successfully, when user's inputs are valid`() {
        // GIVEN
        val console = spyk<Console>()
        every { console.getInput() } returnsMany listOf("a b c", "2")
        val random = spyk(Random.Default)
        every { random.nextInt(any()) } returnsMany listOf(1, 2, 3, 1, 2, 3)
        val gameSystem = GameSystem(UI(console), GameFactory(random))

        // WHEN
        gameSystem.start()

        // THEN
        verifyOrder {
            console.println("이름을 입력하시오.")
            console.getInput()
            console.println("Turn 수:")
            console.getInput()
            console.println("-- 1 번째 턴 --")
            console.println(
                """
                a:-
                b:--
                c:---
                """.trimIndent()
            )
            console.println("-- 2 번째 턴 --")
            console.println(
                """
                a:--
                b:----
                c:------
                """.trimIndent()
            )
            console.println("우승자는 c 입니다.")
        }
    }
}