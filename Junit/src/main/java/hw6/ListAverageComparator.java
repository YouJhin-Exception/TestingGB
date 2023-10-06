package hw6;

import java.util.List;

/**
 * Класс сравнивает средние значения двух списков целых чисел.
 */
public class ListAverageComparator<T extends Number> {

    /**
     * Переменная хранящая первый список чисел для сравнения.
     */
    private List<T> list1;
    /**
     * Переменная хранящая второй список чисел для сравнения.
     */
    private List<T> list2;

    /**
     * Конструктор по умолчанию.
     */
    public ListAverageComparator() {
    }

    /**
     * Конструктор инициализирует оба списка для последующего сравнения.
     *
     * @param listIn1 Первый список для сравнения
     * @param listIn2 Второй список для сравнения
     */
    public ListAverageComparator(final List<T> listIn1,
                                 final List<T> listIn2) {
        if (listIn1 == null || listIn2 == null){
            throw new IllegalArgumentException("Списки не могут быть null");
        }

        this.list1 = listIn1;
        this.list2 = listIn2;
    }

    /**
     * Метод вычисляет среднее значение элементов списка.
     *
     * @param list Список, среднее значение которого нужно вычислить
     * @return Среднее значение элементов списка или 0, если список пуст
     */
    public double calculateAverage(final List<T> list) {
        // Если список пуст, возвращаем 0
        if (list.isEmpty()) {
            return 0;
        }

        // Вычисляем сумму всех чисел в списке
        double sum = 0;
        for (T num : list) {
            sum += num.doubleValue();
        }
        // Возвращаем среднее значение элементов списка
        return sum / list.size();
    }

    /**
     * Метод сравнивает средние значения двух списков
     * и выводит результат сравнения в консоль.
     */
    public void compareAverages() {
        // Вычисляем средние значения
        double average1 = calculateAverage(list1);
        double average2 = calculateAverage(list2);

        // Выводим результат сравнения в консоль
        if (average1 > average2) {
            System.out.println("Первый список имеет большее среднее значение - " + average1);
        } else if (average1 < average2) {
            System.out.println("Второй список имеет большее среднее значение - " + average2);
        } else {
            System.out.println("Средние значения равны");
        }
    }

    /**
     * Геттер для получения первого списка чисел.
     *
     * @return первый список чисел
     */
    public List<T> getList1() {
        return list1;
    }

    /**
     * Геттер для получения второго списка чисел.
     *
     * @return второй список чисел
     */
    public List<T> getList2() {
        return list2;
    }
}


