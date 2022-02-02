import com.example.ConditionCheck;
import com.example.utils.CONNECTORS;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ConditionTest {

    @Test
    @DisplayName("calPUM Test: test the PUM matrix")
    public void calcPUMTest() {
        // this test input follows the example 1 on Page 5-6
        boolean[] CMV = {false, true, true, true, false, false};
        CONNECTORS[][] LCM = {
            {CONNECTORS.ANDD,CONNECTORS.ANDD,CONNECTORS.ORR,CONNECTORS.ANDD,CONNECTORS.NOTUSED,CONNECTORS.NOTUSED},
            {CONNECTORS.ANDD,CONNECTORS.ANDD,CONNECTORS.ORR,CONNECTORS.ORR,CONNECTORS.NOTUSED,CONNECTORS.NOTUSED},
            {CONNECTORS.ORR,CONNECTORS.ORR,CONNECTORS.ANDD,CONNECTORS.ANDD,CONNECTORS.NOTUSED,CONNECTORS.NOTUSED},
            {CONNECTORS.ANDD,CONNECTORS.ORR,CONNECTORS.ANDD,CONNECTORS.ANDD,CONNECTORS.NOTUSED,CONNECTORS.NOTUSED},
            {CONNECTORS.NOTUSED,CONNECTORS.NOTUSED,CONNECTORS.NOTUSED,CONNECTORS.NOTUSED,CONNECTORS.NOTUSED,CONNECTORS.NOTUSED},
            {CONNECTORS.NOTUSED,CONNECTORS.NOTUSED,CONNECTORS.NOTUSED,CONNECTORS.NOTUSED,CONNECTORS.NOTUSED,CONNECTORS.NOTUSED}
        };

        boolean[][] expectedPUM = {
                {true, false, true, false, true, true},
                {false, true, true, true, true, true},
                {true, true, true, true, true, true},
                {false, true, true, true, true, true},
                {true, true, true, true, true, true},
                {true, true, true, true, true, true}
        };
        Assertions.assertArrayEquals(expectedPUM, ConditionCheck.calcPUM(CMV, LCM));
    }

    @Test
    @DisplayName("makeFUV")
    public void makeFUVTest() {

        boolean[] PUV = { true, false, true };

        boolean[][] PUM = {
            { false, true, true, false },
            { true, false, true, true },
            { true, true, true, true }
        };

        boolean[] FUV = ConditionCheck.makeFUV(PUM, PUV);

        Assertions.assertArrayEquals(new boolean[] { false, true, true }, FUV);
    }

    @Test
    @DisplayName("checkFUV: must return true if all the elements are true, otherwise false")
    public void chekcFUVTest() {
        boolean[] positiveFUV = { true, true, true };
        boolean[] negativeFUV = { true, false, true };
        Assertions.assertTrue(ConditionCheck.checkFUV(positiveFUV));
        Assertions.assertFalse(ConditionCheck.checkFUV(negativeFUV));
    }
}
