package self.caloean.roman_to_integer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class RomanToIntegerConverterTest {
    @Test
    public void convertRomanNumeralsToIntegers() {
        // given examples
        assertThat(RomanToIntegerConverter.romanToInteger("VII")).isEqualTo(7);
        assertThat(RomanToIntegerConverter.romanToInteger("IV")).isEqualTo(4);
        assertThat(RomanToIntegerConverter.romanToInteger("XC")).isEqualTo(90);
        assertThat(RomanToIntegerConverter.romanToInteger("XVII")).isEqualTo(17);

        // boundaries
        assertThat(RomanToIntegerConverter.romanToInteger("I")).isEqualTo(1);
        assertThat(RomanToIntegerConverter.romanToInteger("MMMCMXCIX")).isEqualTo(3999);
    }

    @Test
    public void badRomanNumeral() {
        assertThrows(IllegalArgumentException.class, () -> RomanToIntegerConverter.romanToInteger("B"));
    }
}