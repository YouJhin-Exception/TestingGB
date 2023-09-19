package hw3;

public class Main {

    //метод проверяет, является ли переданное число четным или нечетным:
    public boolean evenOddNumber(int n) {
        return n % 2 == 0;
    }

    // метод проверяет, попадает ли переданное число в интервал (25;100)
    public boolean numberInInterval(int n) {
        return n > 25 && n < 100;
    }

}
