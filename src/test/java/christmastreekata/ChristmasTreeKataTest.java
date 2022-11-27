package christmastreekata;

import com.github.ric03.christmastreekata.ChristmasTreeKata;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ChristmasTreeKataTest {

    ChristmasTreeKata uut = new ChristmasTreeKata();

    @Test
    void givenSize_whenDrawTree_thenResultIsNotNull() {
        assertThat(uut.drawTree()).isNotNull();
    }
}
