import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.collections.shouldContainInOrder
import io.kotest.matchers.collections.shouldHaveSingleElement
import io.kotest.matchers.collections.shouldStartWith

class ChristmasTreeKataKtTest : FreeSpec({

    "drawTree with size <= 0" - {
        listOf(-99, -1, 0).forEach { size ->
            "it should return the tree stump with size=$size" {
                drawTree(size) shouldHaveSingleElement "|"
            }
        }
    }

    "drawTree with proper indentation" - {
        listOf(
            1 to "X",
            2 to " X",
            3 to "  X",
        ).forEach { (size: Int, properIndentation: String) ->
            val indentation = properIndentation.length - 1
            "it should return a list where the first element has an indentation of $indentation" {
                drawTree(size) shouldStartWith properIndentation
            }
        }
    }
    
    "drawTree with size 1 should return 1 row of leaves and a stump" {
        drawTree(1) shouldContainInOrder listOf(
            "X",
            "|"
        )
    }

    "drawTree with size 2 should return 2 rows of leaves and a stump" {
        drawTree(2) shouldContainInOrder listOf(
            " X",
            "XXX",
            " |"
        )
    }

    "drawTree with size 3 should return 3 rows of leaves and a stump" {
        drawTree(3) shouldContainInOrder listOf(
            "  X",
            " XXX",
            "XXXXX",
            "  |"
        )
    }

    "drawTree with size 5 should return 5 rows of leaves and a stump" {
        drawTree(5) shouldContainInOrder listOf(
            "    X",
            "   XXX",
            "  XXXXX",
            " XXXXXXX",
            "XXXXXXXXX",
            "    |"
        )
    }

})

