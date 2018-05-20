package boggle

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class SolutionKtTest {

    @Test
    fun testBoggle() {

        val boggle: Array<Array<Char>> = arrayOf(
                arrayOf('H', 'I', 'Z'),
                arrayOf('U', 'A', 'R'),
                arrayOf('Q', 'N', 'B')
        )
        assertTrue(isWord("HABR", boggle))
        assertTrue(isWord("QUIZ", boggle))
        assertFalse(isWord("FOR", boggle))
        assertFalse(isWord("GO", boggle))
    }
}