package rep.can.bakery.order;

import org.junit.jupiter.api.Test;
import rep.can.bakery.order.utils.MathUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {

    @Test
    public void givenEmptyDivisors_whenGetDivisionFactors_thenEmptyResultReturned() {

        Map divisionFactors = MathUtils.getDivisionFactors(28, Collections.EMPTY_LIST);
        assertTrue(divisionFactors.isEmpty());
    }

    @Test
    public void givenAccurateDivisors_whenGetDivisionFactors_thenExpectedResultReturned() {
        Map<Integer, Integer> divisionFactors = MathUtils.getDivisionFactors(14, Arrays.asList(2, 8));

        assertEquals(0, divisionFactors.get(2).compareTo(3));
        assertEquals(0, divisionFactors.get(8).compareTo(1));
        assertEquals(2, divisionFactors.size());

        Map<Integer, Integer> divisionFactors2 = MathUtils.getDivisionFactors(13, Arrays.asList(9, 5, 3));

        assertEquals(0, divisionFactors2.get(5).compareTo(2));
        assertEquals(0, divisionFactors2.get(3).compareTo(1));
        assertEquals(2, divisionFactors2.size());

        Map<Integer, Integer> divisionFactors3 = MathUtils.getDivisionFactors(14, Arrays.asList(2, 5, 8));

        assertEquals(0, divisionFactors3.get(8).compareTo(1));
        assertEquals(0, divisionFactors3.get(2).compareTo(3));
        assertEquals(2, divisionFactors3.size());


    }

    @Test
    public void givenNotAccurateDivisors_whenGetDivisionFactors_thenEmptyResultReturned() {

        Map divisionFactors = MathUtils.getDivisionFactors(28, Arrays.asList(30, 32));
        assertTrue(divisionFactors.isEmpty());

        Map divisionFactors2 = MathUtils.getDivisionFactors(14, Arrays.asList(4, 8));
        assertTrue(divisionFactors2.isEmpty());


    }
}
