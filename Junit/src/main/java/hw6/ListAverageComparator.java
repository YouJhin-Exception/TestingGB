package hw6;

import java.util.List;
/**
 * Класс сравнивает средние значения двух списков целых чисел.
 */
public class ListAverageComparator {
    // Первый список для сравнения
    private List<Integer> list1;
    // Второй список для сравнения
    private List<Integer> list2;

    /**
     * Конструктор по умолчанию.
     */
    public ListAverageComparator() {
    }

    /**
     * Конструктор инициализирует оба списка для последующего сравнения.
     *
     * @param list1 Первый список для сравнения
     * @param list2 Второй список для сравнения
     */
    public ListAverageComparator(List<Integer> list1, List<Integer> list2) {
        this.list1 = list1;
        this.list2 = list2;
    }

    /**
     * Метод вычисляет среднее значение элементов списка.
     *
     * @param list Список, среднее значение которого нужно вычислить
     * @return Среднее значение элементов списка или 0, если список пуст
     */
    public double calculateAverage(List<Integer> list) {
        // Если список пуст, возвращаем 0
        if (list.isEmpty()) return 0;

        // Вычисляем сумму всех чисел в списке
        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        // Возвращаем среднее значение элементов списка
        return (double) sum / list.size();
    }

    /**
     * Метод сравнивает средние значения двух списков и выводит результат сравнения в консоль.
     */
    public void compareAverages() {
        // Вычисляем средние значения
        double average1 = calculateAverage(list1);
        double average2 = calculateAverage(list2);

        // Выводим результат сравнения в консоль
        if (average1 > average2) {
            System.out.println("Первый список имеет большее среднее значение - "+ average1);
        } else if (average1 < average2) {
            System.out.println("Второй список имеет большее среднее значение - "+ average2);
        } else {
            System.out.println("Средние значения равны");
        }
    }

    /**
     * Геттеры для получения листов
     */
    public List<Integer> getList1() {
        return list1;
    }

    public List<Integer> getList2() {
        return list2;
    }
}


