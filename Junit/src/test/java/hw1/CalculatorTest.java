package hw1;

import org.assertj.core.api.Assertions;
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

        // Проверяем, что метод выбрасывает исключение для отрицательной суммы покупки
        assertThatThrownBy(() -> Calculator.calculateDiscount(negativeAmount, 10.0)).isInstanceOf(ArithmeticException.class).hasMessage("Сумма покупки не может быть отрицательной");

        // Проверяем, что метод выбрасывает исключение для отрицательного процента скидки
        assertThatThrownBy(() -> Calculator.calculateDiscount(100.0, negativeDiscount)).isInstanceOf(ArithmeticException.class).hasMessage("Скидка должна быть в диапазоне от 0 до 100%");

        // Проверяем, что метод выбрасывает исключение для скидки более 100%
        assertThatThrownBy(() -> Calculator.calculateDiscount(100.0, discountOver100)).isInstanceOf(ArithmeticException.class).hasMessage("Скидка должна быть в диапазоне от 0 до 100%");

//        Assertions.assertThat(Calculator.calculateDiscount(1000, 20)).isEqualTo(800.0);
//        Assertions.assertThat(Calculator.calculateDiscount(1000.0, 100)).isEqualTo(0.0);
//        Assertions.assertThat(Calculator.calculateDiscount(1000.0, 0)).isEqualTo(1000.0);

    }
    public static void main(String[] args) {

       Calculator.calculateDiscount(100,10);

    }

    // Проверка базового функционала с целыми числами:
//        if (8 != Calculator.calculation(2, 6, '+')) {
//            throw new AssertionError("Ошибка в методе");
//        }
//
//        if (0 != Calculator.calculation(2, 2, '-')) {
//            throw new AssertionError("Ошибка в методе");
//        }
//
//        if (14 != Calculator.calculation(2, 7, '*')) {
//            throw new AssertionError("Ошибка в методе");
//        }
//
//        if (2 != Calculator.calculation(100, 50, '/')) {
//            throw new AssertionError("Ошибка в методе");
//        }

    // Случаи с неправильными аргументами
    // аргумент operator типа char, должен вызывать исключение, если он получает не базовые символы (+-*/)
    // try {
    //     seminars.first.Calculator.Calculator.calculation(8, 4, '_');
    // } catch (IllegalStateException e) {
    //     if (!e.getMessage().equals("Unexpected value operator: _")) {
    //         throw new AssertionError("Ошибка в методе");
    //     }
    // }

    // Проверка базового функционала с целыми числами, с использованием утверждений:
//        assert 8 == Calculator.calculation(2, 6, '+');
//        assert 0 == Calculator.calculation(2, 2, '-');
//        assert 14 == Calculator.calculation(2, 7, '*');
//        assert 2 == Calculator.calculation(100, 50, '/');

    // Проверка базового функционала с целыми числами, с использованием утверждений AssertJ:
//        assertThat(Calculator.calculation(2, 6, '+')).isEqualTo(8);
//        assertThat(Calculator.calculation(2, 2, '-')).isEqualTo(0);
//        assertThat(Calculator.calculation(2, 7, '*')).isEqualTo(14);
//        assertThat(Calculator.calculation(100, 50, '/')).isEqualTo(2);

    // Проверка ожидаемого исключения, с использованием утверждений AssertJ:
//        assertThatThrownBy(() ->
//                Calculator.calculation(8, 4, '_')
//        ).isInstanceOf(IllegalStateException.class);
//
//        System.out.println(Calculator.calculation(2_147_483_647, 1, '+')); // integer overflow
//        System.out.println(Calculator.squareRootExtraction(169));

    // Примерные решения домашних заданий из 1 лекции:

    // HW1.1: Придумайте и опишите (можно в псевдокоде) функцию извлечения корня и
    // необходимые проверки для него используя граничные случаи
    // assertThatThrownBy(() ->
    //         seminars.first.Calculator.Calculator.squareRootExtraction(0, 1, -1)
    // ).isInstanceOf(SomeStateException.class);

    // HW1.2: Как будет выглядеть проверка для случая деления на ноль? (с использованием AssertJ)
    // assertThatThrownBy(() ->
    //        seminars.first.Calculator.Calculator.calculation(5, 0, '/')
    // ).isInstanceOf(ArithmeticException.class);

    // HW1.3: Сравните одну и ту же проверку с использованием условий, ассертов, AssertJ
    // в каком случае стандартное сообщение об ошибке будет более информативным?
    // if (0 != seminars.first.Calculator.Calculator.calculation(2, 6, '+')) {
    //     throw new AssertionError("Ошибка в методе");
    // }
    //   assert 0 == seminars.first.Calculator.Calculator.calculation(2, 6, '+');
    //    assertThat(seminars.first.Calculator.Calculator.calculation(2, 6, '+')).isEqualTo(0);


//    }
}