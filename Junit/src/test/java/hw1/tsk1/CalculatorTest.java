package hw1.tsk1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    // Тест для проверки правильности расчета скидки
    @Test
    public void testValidDiscountCalculation() {
        double purchaseAmount = 100.0;
        double discountPercentage = 10.0;

        // Вычисляем сумму с учетом скидки
        double discountedAmount = Calculator.calculateDiscount(purchaseAmount, discountPercentage);

        // Проверяем, что результат равен ожидаемой сумме
        assertThat(discountedAmount).isEqualTo(90.0);
    }

    // Тесты для проверки выбрасывания исключения при недопустимых аргументах
    @Test
    public void testInvalidArguments() {
        double negativeAmount = -100.0;
        double negativeDiscount = -10.0;
        double discountOver100 = 110.0;

        //через исключение
        // Проверяем, что метод выбрасывает исключение для отрицательной суммы покупки
        assertThatThrownBy(() -> Calculator.calculateDiscount(negativeAmount, 10.0)).isInstanceOf(ArithmeticException.class).hasMessage("Сумма покупки не может быть отрицательной");

        // Проверяем, что метод выбрасывает исключение для отрицательного процента скидки
        assertThatThrownBy(() -> Calculator.calculateDiscount(100.0, negativeDiscount)).isInstanceOf(ArithmeticException.class).hasMessage("Скидка должна быть в диапазоне от 0 до 100%");

        // Проверяем, что метод выбрасывает исключение для скидки более 100%
        assertThatThrownBy(() -> Calculator.calculateDiscount(100.0, discountOver100)).isInstanceOf(ArithmeticException.class).hasMessage("Скидка должна быть в диапазоне от 0 до 100%");

        //через equal

//        Assertions.assertThat(Calculator.calculateDiscount(1000, 20)).isEqualTo(800.0);
//        Assertions.assertThat(Calculator.calculateDiscount(1000.0, 100)).isEqualTo(0.0);
//        Assertions.assertThat(Calculator.calculateDiscount(1000.0, 0)).isEqualTo(1000.0);

    }

    public static void main(String[] args) {

        //Calculator.calculateDiscount(100, 10);

    }
}