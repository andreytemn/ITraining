package boggle

class Matrix(private val arrays: Array<Array<Char>>) {
    private var map: Map<Point, Char> = HashMap()

    init {
        for (x in arrays.indices) {
            for (y in arrays[x].indices) {
                map += (Pair(Point(x, y), arrays[x][y]))
            }
        }
    }

    /**
     * Returns all chars in matrix.
     */
    fun allElements(): Collection<Char> {
        return map.values
    }

    /**
     * Returns true if matrix contains all chars in given string
     */
    fun hasChars(str: String): Boolean {
        return str.all { allElements().contains(it) }
    }

    /**
     * Returns List of Points showing word path in matrix. If there is no such word then returns null.
     */
    fun getChain(word: String): List<Point>? {
        val chain = ArrayList<Point>()
        for (char in word) {

            val point = findNextPoint(char, chain) ?: return null
            chain += point
        }
        return chain
    }

    private fun getPoint(element: Char, excluded: List<Point> = emptyList()): Point? {
        for ((key, value) in map) {
            if (value == element && !excluded.contains(key)) return key
        }
        return null
    }

    private fun findNextPoint(char: Char, usedPoints: List<Point>): Point? {
        var used = usedPoints
        val point = getPoint(char, usedPoints) ?: return null
        if (usedPoints.isEmpty())
            return point

        val previous = usedPoints.last()
        if (checkPointHits(previous, point))
            return point
        used += point
        return findNextPoint(char, used)
    }

    private fun checkPointHits(point1: Point, point2: Point): Boolean {
        val xDistance = Math.abs(point1.x - point2.x)
        val xFits = xDistance <= 1 || xDistance == arrays.size - 1

        val yDistance = Math.abs(point1.y - point2.y)
        val yFits = yDistance <= 1 || yDistance == arrays[point1.x].size - 1

        return xFits && yFits
    }
}

data class Point(val x: Int, val y: Int)