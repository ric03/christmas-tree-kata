private const val AIR = " "
private const val LEAVE = "X"
private const val STUMP = "|"

fun drawTree(size: Int): List<String> {
    if (size <= 0) return listOf(STUMP)

    val leaves = List(size) { index ->
        val indentation = AIR.repeat(size - index - 1)
        val leaves = LEAVE.repeat(index * 2 + 1)
        indentation.plus(leaves)
    }

    val indentation = AIR.repeat(size - 1)
    val stump = indentation.plus(STUMP)

    return leaves.plus(stump)
}
