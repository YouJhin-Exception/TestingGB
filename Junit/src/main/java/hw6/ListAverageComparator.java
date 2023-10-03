package hw6;

import java.util.List;

/**
 * Класс сравнивает средние значения двух списков целых чисел.
 */
public class ListAverageComparator {

    /**
     * Переменная хранящая первый список чисел для сравнения.
     */
    private List<Integer> list1;
    /**
     * Переменная хранящая второй список чисел для сравнения.
     */
    private List<Integer> list2;

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
    public ListAverageComparator(final List<Integer> listIn1,
                                 final List<Integer> listIn2) {
        this.list1 = listIn1;
        this.list2 = listIn2;
    }

    /**
     * Метод вычисляет среднее значение элементов списка.
     *
     * @param list Список, среднее значение которого нужно вычислить
     * @return Среднее значение элементов списка или 0, если список пуст
     */
    public double calculateAverage(final List<Integer> list) {
        // Если список пуст, возвращаем 0
        if (list.isEmpty()) {
            return 0;
        }

        // Вычисляем сумму всех чисел в списке
        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        // Возвращаем среднее значение элементов списка
        return (double) sum / list.size();
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
    public List<Integer> getList1() {
        return list1;
    }

    /**
     * Геттер для получения второго списка чисел.
     *
     * @return второй список чисел
     */
    public List<Integer> getList2() {
        return list2;
    }
}


