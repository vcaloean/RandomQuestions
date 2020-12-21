package self.caloean.roman_to_integer;

import java.util.Locale;
import java.util.Map;

/**
 * A utility class to convert Roman numerals to their integer representation.
 */
public class RomanToIntegerConverter {
    private static final Map<Character, Integer> romanToInteger;

    static {
        romanToInteger = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
        );
    }

    /**
     * Given a roman numeral, return the equivalent integer representation. Roman numerals may only have the
     * following letters:
     * <pre>
     * I (1)
     * V (5)
     * X (10)
     * L (50)
     * C (100)
     * D (500)
     * M (1000)
     * </pre>
     *
     * @param romanNumeral The Roman numeral to convert
     * @return the integer representation
     * @throws IllegalArgumentException if any of the letters used in the Roman numeral are illegal
     */
    public static int romanToInteger(String romanNumeral) {
        char[] letters = romanNumeral.toUpperCase(Locale.US).toCharArray();

        int sum = 0;
        int previousNumber = 0;
        for (char currentLetter : letters) {
            if (!romanToInteger.containsKey(currentLetter)) {
                throw new IllegalArgumentException("Illegal character; not a Roman numeral: " + currentLetter);
            }

            int currentNumber = romanToInteger.get(currentLetter);

            if (previousNumber == 0) {
                previousNumber = currentNumber;
                continue;
            }

            if (previousNumber >= currentNumber) {
                sum += previousNumber;
                previousNumber = currentNumber;
            } else {
                sum += currentNumber - previousNumber;
                previousNumber = 0;
            }
        }

        sum += previousNumber;
        return sum;
    }
}
