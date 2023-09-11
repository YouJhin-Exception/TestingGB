package hw1.tsk1;

public class Calculator {
    public static int calculation(int firstOperand, int secondOperand, char operator) {
        int result;

        switch (operator) {
            case '+' -> result = firstOperand + secondOperand;
            case '-' -> result = firstOperand - secondOperand;
            case '*' -> result = firstOperand * secondOperand;
            case '/' -> {
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                } else {
                    throw new ArithmeticException("Division by zero is not possible");
                }
            }
            default -> throw new IllegalStateException("Unexpected value operator: " + operator);
        }
        return result;
    }

    //hw1

    // Метод для расчета суммы с учетом скидки
    // принимает сумму покупки и процент скидки
    // возвращает сумму с учетом скидки
    public static double calculateDiscount(double purchaseAmount, double discountPercentage) {
        if (purchaseAmount >= 0) {
            if (discountPercentage >= 0 && discountPercentage <= 100) {
                return purchaseAmount - purchaseAmount * (discountPercentage / 100);
            } else {
                throw new ArithmeticException("Скидка должна быть в диапазоне от 0 до 100%");
            }
        } else {
            throw new ArithmeticException("Сумма покупки не может быть отрицательной");
        }


        // Проверка на недопустимые аргументы v1
//        if (purchaseAmount <= 0 || discountPercentage < 0 || discountPercentage > 100) {
//            // Если аргументы недопустимы, выбрасываем исключение ArithmeticException
//            throw new ArithmeticException("Недопустимые аргументы");
//        }
//
//        // Рассчитываем сумму с учетом скидки
//        double discountAmount = purchaseAmount * (discountPercentage / 100);
//        return purchaseAmount - discountAmount;

    }
}