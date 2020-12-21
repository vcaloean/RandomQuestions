package self.caloean.roman_to_integer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RomanToIntegerConverterTest {
    @Test
    public void convertRomanNumeralsToIntegers() {
        assertThat(RomanToIntegerConverter.romanToInteger("VII")).isEqualTo(7);
        assertThat(RomanToIntegerConverter.romanToInteger("IV")).isEqualTo(4);
        assertThat(RomanToIntegerConverter.romanToInteger("XC")).isEqualTo(90);
        assertThat(RomanToIntegerConverter.romanToInteger("XVII")).isEqualTo(17);
    }
}