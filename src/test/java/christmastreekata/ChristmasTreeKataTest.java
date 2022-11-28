package christmastreekata;

import com.github.ric03.christmastreekata.ChristmasTreeKata;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class ChristmasTreeKataTest {

    ChristmasTreeKata uut = new ChristmasTreeKata();

    @Test
    void givenSize_whenDrawTree_thenResultIsNotNull() {
        assertThat(uut.drawTree(1)).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {-99, -1, 0})
    void givenZeroOrNegativeSize_whenDrawTree_thenReturnOnlyTreeStump(int size) {
        // Act
        var result = uut.drawTree(size);
        // Assert
        assertThat(result).containsExactly("|");
    }

    @ParameterizedTest
    @CsvSource({"1,X", "2,-X", "3,--X"})
    void givenZeroOrNegativeSize_whenDrawTree_thenReturnOnlyTreeStump(int size, String expectedIndentation) {
        // Act
        var result = uut.drawTree(size);
        // Assert
        assertThat(result).containsOnlyOnce(expectedIndentation.replace('-', ' '));
    }

    @Test
    void givenSize1_whenDrawTree_thenReturn1RowsOfLeavesAndATreeStump() {
        // Act
        var result = uut.drawTree(1);
        // Assert
        assertThat(result).containsExactly(
            "X",
            "|"
        );
    }

    @Test
    void givenSize2_whenDrawTree_thenReturn2RowsOfLeavesAndATreeStump() {
        // Act
        var result = uut.drawTree(2);
        // Assert
        assertThat(result).containsExactly(
            " X",
            "XXX",
            " |"
        );
    }

    @Test
    void givenSize3_whenDrawTree_thenReturn3RowsOfLeavesAndATreeStump() {
        // Act
        var result = uut.drawTree(3);
        // Assert
        assertThat(result).containsExactly(
            "  X",
            " XXX",
            "XXXXX",
            "  |"
        );
    }

    @Test
    void givenSize5_whenDrawTree_thenReturn5RowsOfLeavesAndATreeStump() {
        // Act
        var result = uut.drawTree(5);
        // Assert
        assertThat(result).containsExactly(
            "    X",
            "   XXX",
            "  XXXXX",
            " XXXXXXX",
            "XXXXXXXXX",
            "    |"
        );
    }

}
