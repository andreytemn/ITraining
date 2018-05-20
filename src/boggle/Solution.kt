package boggle

/**
 * Given a dictionary, a method to do lookup in dictionary and a M x N board where every cell has one character. Find all possible words that can be formed by a sequence of adjacent characters. Note that we can move to any of 8 adjacent characters, but a word should not have multiple instances of same cell.

Example:

Input: dictionary[] = {«HABR», «FOR», «QUIZ», «GO»};

boggle[][] = {{'H','I','Z'},
{'U','A','R'},
{'Q','N','B'}};

isWord(str): returns true if str is present in dictionary
else false.

Output: Following words of dictionary are present
HABR
QUIZ
 */

fun isWord(str: String, boggle: Array<Array<Char>>): Boolean {
    val matrix = Matrix(boggle)
    if (!matrix.hasChars(str)) {
        return false
    }
    return matrix.getChain(str) != null
}

