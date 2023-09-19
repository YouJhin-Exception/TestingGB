package hw3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private Main main;

    @BeforeEach
    void setUp() {
        main = new Main();
    }

    @Test
    void evenOddNumberTest() {
        assertAll(
                () -> assertThat(main.evenOddNumber(10)).isEqualTo(true),
                () -> assertThat(main.evenOddNumber(1)).isEqualTo(false)
        );
    }

    // тестировал различные способы тестов (для себя) (хотя этот тест и избыточен, было интересно как можно реализовать проверку массива)
    @ParameterizedTest
    @ValueSource(ints = {10, 1, -4, 7, 8})
    void testEvenAndOddNumber(int number) {
        if (number % 2 == 0) {
            assertTrue(main.evenOddNumber(number));
        } else {
            assertFalse(main.evenOddNumber(number));
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9})
    void falseTestOddNumber(int number) {
        assertFalse(main.evenOddNumber(number));
    }

    @Test
    void numberInIntervalTest() {
        assertAll(
                () -> assertThat(main.numberInInterval(26)).isEqualTo(true),
                () -> assertThat(main.numberInInterval(120)).isEqualTo(false)
        );

    }

    @ParameterizedTest
    @ValueSource(ints = {26, 27, 28, 29, 99})
    void numberInIntervalTrueTest(int number) {
        assertTrue(main.numberInInterval(number));
    }

}