import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class BasicTest {

    @Test
    @DisplayName("A passing test")
    public void positiveTest() {
        assert(true);
    }

    @Test
    @DisplayName("Catching an Exception")
    public void negativeTest() {
        assertThrows(Exception.class, () -> {

        });
    }
}
