package rep.can.bakery.order.utils;

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

        Integer holdNumber = effectiveDivisors.pop();
        LinkedList<Integer> remainingDivisors = new LinkedList<>(effectiveDivisors);

        do {
            if (remainingDivisors.size() == 0 && divisors.size() > 2) {
                holdNumber = effectiveDivisors.pop();
                remainingDivisors.addAll(new LinkedList<>(effectiveDivisors));
            }

            LinkedList<Integer> numbersToIterate = merge(holdNumber, remainingDivisors);

            //Clear all previous calculation result to iterate on new divisor list
            result = new HashMap<>();
            effectiveDividend = getSequence(result, dividend, numbersToIterate);

            if (effectiveDividend != 0) {
                remainingDivisors.pop();
            }

        } while (effectiveDividend != 0 && effectiveDivisors.size() > 0);


        return effectiveDividend == 0 ? result : Collections.EMPTY_MAP;

    }

    private static LinkedList<Integer> merge(Integer holdNumber, LinkedList<Integer> effectiveDivisors) {
        LinkedList<Integer> output = new LinkedList<>();
        output.add(holdNumber);
        output.addAll(effectiveDivisors);

        return output;
    }

    private static Integer getSequence(Map<Integer, Integer> resultToMutate, Integer dividend, LinkedList<Integer> effectiveDivisors) {
        Integer effectiveDividend = dividend;

        //Clear all previous calculation result to iterate on new divisor list
        Map<Integer, Integer> result = new HashMap<>();

        //Set effective dividend as original dividend value to iterate on new divisor list

        for (int i = 0; i < effectiveDivisors.size() && effectiveDividend > 0; i++) {

            Integer divisor = effectiveDivisors.get(i);

            int remainder = effectiveDividend / divisor;

            result.put(divisor, remainder);

            effectiveDividend = effectiveDividend - (remainder * divisor);
        }

        resultToMutate.putAll(result);
        return effectiveDividend;

    }
}
