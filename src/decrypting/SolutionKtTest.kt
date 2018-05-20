package decrypting

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class SolutionKtTest {

    @Test
    fun testEmpty() {
        assertEquals(1, countDecryptingWays(""))
    }

    @Test
    fun testTwoZeros() {
        assertEquals(0, countDecryptingWays("00"))
        assertEquals(0, countDecryptingWays("12300"))
    }

    @Test
    fun testLeadingZeros() {
        assertEquals(0,countDecryptingWays("01"))
    }

    @Test
    fun testPositive() {
        assertEquals(1, countDecryptingWays("1"))
        assertEquals(3, countDecryptingWays("123"))
        assertEquals(3, countDecryptingWays("12345"))
        assertEquals(2, countDecryptingWays("21"))
    }
}