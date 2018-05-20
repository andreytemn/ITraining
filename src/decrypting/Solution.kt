package decrypting

/**
 * A top secret message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
…
'Z' -> 26

You are an FBI agent. You have to determine the total number of ways that message can be decoded.
Note: An empty digit sequence is considered to have one decoding. It may be assumed that the input contains valid digits from 0 to 9 and If there are leading 0’s, extra trailing 0’s and two or more consecutive 0’s then it is an invalid string.

Example:
Given encoded message «123», it could be decoded as «ABC» (1 2 3) or «LC» (12 3) or «AW»(1 23).
So total ways are 3.
 */
fun main(args: Array<String>) {
    println(countDecryptingWays(args[0]))
}

fun countDecryptingWays(str: String): Int {
    if (str.length == 0)
        return 1
    if (str.startsWith("0"))
        return 0
    if (str.contains("00"))
        return 0

    var count = 1
    for (i in str.indices) {
        val char = str[i]
        if (char != '1' && char != '2')
            continue
        if (char == '1' && i <= str.length - 2)
            count++
        if (char == '2' && i <= str.length - 2 && str[i + 1].toString().toInt() in 0..6)
            count++
    }
    return count
}