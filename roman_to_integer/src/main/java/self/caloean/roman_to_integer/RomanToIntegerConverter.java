package self.caloean.roman_to_integer;

import java.util.Locale;
import java.util.Map;

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

    public static int romanToInteger(String romanNumeralRepresentation) {
        char[] letters = romanNumeralRepresentation.toUpperCase(Locale.US).toCharArray();

        int[] numbers = new int[letters.length];
        for (int i = 0; i < letters.length; i++) {
            char currentLetter = letters[i];
            if (!romanToInteger.containsKey(currentLetter)) {
                throw new IllegalArgumentException("Illegal character; not a Roman numeral: " + currentLetter);
            }

            numbers[i] = romanToInteger.get(currentLetter);
        }

        if (numbers.length == 1) {
            return numbers[0];
        }

        int sum = 0;
        int endIndex = numbers.length - 1;
        for (int i = 0; i <= endIndex; i++) {
            int currentNumber = numbers[i];

            if (i == endIndex) {
                sum += currentNumber;
            } else {
                int nextNumber = numbers[i + 1];
                if (currentNumber >= nextNumber) {
                    sum += currentNumber;
                } else {
                    sum += nextNumber - currentNumber;
                    i++;
                }
            }
        }

        return sum;
    }
}
