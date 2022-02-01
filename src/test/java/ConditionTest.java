import com.example.ConditionCheck;
import com.example.utils.LogicEnum;
import com.example.utils.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ConditionTest {

    @Test
    @DisplayName("calPUM Test: test the PUM matrix")
    public void calcPUMTest() {
        // this test input follows the example 1 on Page 5-6
        boolean[] CMV = {false, true, true, true, false, false};
        LogicEnum[][] LIC = {
                {LogicEnum.ANDD, LogicEnum.ANDD, LogicEnum.ORR, LogicEnum.ANDD, LogicEnum.NOTUSED, LogicEnum.NOTUSED},
                {LogicEnum.ANDD, LogicEnum.ANDD, LogicEnum.ORR, LogicEnum.ORR, LogicEnum.NOTUSED, LogicEnum.NOTUSED},
                {LogicEnum.ORR, LogicEnum.ORR, LogicEnum.ANDD, LogicEnum.ANDD, LogicEnum.NOTUSED, LogicEnum.NOTUSED},
                {LogicEnum.ANDD, LogicEnum.ORR, LogicEnum.ANDD, LogicEnum.ANDD, LogicEnum.NOTUSED, LogicEnum.NOTUSED},
                {LogicEnum.NOTUSED, LogicEnum.NOTUSED, LogicEnum.NOTUSED, LogicEnum.NOTUSED, LogicEnum.NOTUSED, LogicEnum.NOTUSED},
                {LogicEnum.NOTUSED, LogicEnum.NOTUSED, LogicEnum.NOTUSED, LogicEnum.NOTUSED, LogicEnum.NOTUSED, LogicEnum.NOTUSED}
        };

        boolean[][] expectedPUM = {
                {true, false, true, false, true, true},
                {false, true, true, true, true, true},
                {true, true, true, true, true, true},
                {false, true, true, true, true, true},
                {true, true, true, true, true, true},
                {true, true, true, true, true, true}
        };

        Assertions.assertArrayEquals(expectedPUM, ConditionCheck.calcPUM(CMV, LIC));
    }
}
