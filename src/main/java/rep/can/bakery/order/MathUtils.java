package rep.can.bakery.order;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class MathUtils {

    private MathUtils() {
    }

    /**
     * @param dividend number as dividend
     * @param divisors numbers as divisors
     * @return Divisor and Factor map
     * If dividend can be divided by divisors until remainder equals to Zero
     * Otherwise Empty Map
     */
    public static Map<Integer, Integer> getDivisionFactors(Integer dividend, List<Integer> divisors) {

        divisors.sort(Collections.reverseOrder());

        LinkedList<Integer> effectiveDivisors = new LinkedList<>(divisors);

        Map<Integer, Integer> result;
        Integer effectiveDividend;

        do {
            //Clear all previous calculation result to iterate on new divisor list
            result = new HashMap<>();

            //Set effective dividend as original dividend value to iterate on new divisor list
            effectiveDividend = dividend;

            for (int i = 0; i < effectiveDivisors.size() && effectiveDividend > 0; i++) {

                Integer divisor = effectiveDivisors.get(i);

                int remainder = effectiveDividend / divisor;

                result.put(divisor, remainder);

                effectiveDividend = effectiveDividend - (remainder * divisor);
            }

            //Remove the greatest divisor and try calculation again on remaining ones
            effectiveDivisors.pop();

        } while (effectiveDividend != 0 && effectiveDivisors.size() > 0);


        return effectiveDividend == 0 ? result : Collections.EMPTY_MAP;

    }
}
