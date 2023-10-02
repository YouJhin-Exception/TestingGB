package hw6;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Тесты для класса ListAverageComparator.
 */
class ListAverageComparatorTest {

    /**
     * Проверяет, что конструктор правильно устанавливает списки.
     */
    @Test
    @DisplayName("Проверка, что конструктор правильно устанавливает списки.")
    void constructorShouldSetLists() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);

        ListAverageComparator comparator = new ListAverageComparator(list1, list2);

        assertSame(list1, comparator.getList1());
        assertSame(list2, comparator.getList2());
    }

    /**
     * Проверяет, что конструктор правильно устанавливает нулевые списки.
     */
    @Test
    @DisplayName("Проверка, что конструктор правильно устанавливает нулевые списки.")
    void constructorShouldHandleNullLists() {
        ListAverageComparator comparator = new ListAverageComparator(null, null);

        assertNull(comparator.getList1());
        assertNull(comparator.getList2());
    }

    /**
     * Проверяет, что метод calculateAverage возвращает 0 для пустого списка.
     */
    @Test
    @DisplayName("Проверка, что метод calculateAverage возвращает 0 для пустого списка.")
    void calculateAverageShouldReturnZeroForEmptyList() {
        ListAverageComparator comparator = new ListAverageComparator(null, null);

        double average = comparator.calculateAverage(List.of());

        assertEquals(0, average, 0.0001); // дельта - погрешность
    }

    /**
     * Проверяет, что метод calculateAverage возвращает правильное значение для отрицательного списка.
     */
    @Test
    @DisplayName("Проверка, что метод calculateAverage возвращает правильное значение для отрицательного списка.")
    void calculateAverageShouldHandleNegativeNumbers() {
        List<Integer> list = Arrays.asList(-1, -2, -3, -4, -5);
        ListAverageComparator comparator = new ListAverageComparator(null, null);

        double average = comparator.calculateAverage(list);

        assertEquals(-3.0, average, 0.0001);
    }

    /**
     * Проверяет, что метод calculateAverage возвращает правильное среднее значение для списка.
     */
    @Test
    @DisplayName("Проверка, что метод calculateAverage возвращает правильное среднее значение для списка.")
    void calculateAverageShouldReturnCorrectAverage() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        ListAverageComparator comparator = new ListAverageComparator(null, null);

        double average = comparator.calculateAverage(list);

        assertEquals(3.0, average, 0.0001);
    }


    /**
     * Проверяет, что метод compareAverages правильно выводит большее среднее значение для первого списка.
     */
    @Test
    @DisplayName("Проверка, что метод compareAverages правильно выводит большее среднее значение для первого списка.")
    void compareAveragesShouldPrintGreaterAverageForFirstList() {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(1, 2, 3);

        ListAverageComparator comparator = new ListAverageComparator(list1, list2);

        String expectedOutput = "Первый список имеет большее среднее значение - 3.0";

        assertDoesNotThrow(() -> {
            String actualOutput = getOutput(comparator::compareAverages);
            assertEquals(expectedOutput.trim(), actualOutput.trim());
        });
    }

    /**
     * Проверяет, что метод compareAverages правильно выводит большее среднее значение для второго списка.
     */
    @Test
    @DisplayName("Проверка, что метод compareAverages правильно выводит большее среднее значение для второго списка.")
    void compareAveragesShouldPrintGreaterAverageForSecondList() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5);

        ListAverageComparator comparator = new ListAverageComparator(list1, list2);

        String expectedOutput = "Второй список имеет большее среднее значение - 3.0";

        assertDoesNotThrow(() -> {
            String actualOutput = getOutput(comparator::compareAverages);
            assertEquals(expectedOutput.trim(), actualOutput.trim());
        });
    }


    /**
     * Проверяет, что метод compareAverages правильно выводит сообщение о равных средних значениях.
     */
    @Test
    @DisplayName("Проверка, что метод compareAverages правильно выводит сообщение о равных средних значениях.")
    void compareAveragesShouldPrintEqualAverages() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(1, 2, 3);

        ListAverageComparator comparator = new ListAverageComparator(list1, list2);

        String expectedOutput = "Средние значения равны\n";

        assertDoesNotThrow(() -> {
            String actualOutput = getOutput(comparator::compareAverages);
            assertEquals(expectedOutput.trim(), actualOutput.trim());
        });
    }

    /**
     * Проверяет, что метод compareAverages обрабатывает случай, когда оба переданных списка пусты.
     */
    @Test
    @DisplayName("Проверка, что метод compareAverages обрабатывает случай, когда оба переданных списка пусты.")
    void compareAveragesShouldHandleEmptyLists() {
        ListAverageComparator comparator = new ListAverageComparator(Collections.emptyList(), Collections.emptyList());

        String expectedOutput = "Средние значения равны\n";

        assertDoesNotThrow(() -> {
            String actualOutput = getOutput(comparator::compareAverages);
            assertEquals(expectedOutput.trim(), actualOutput.trim());
        });
    }

    /**
     * Проверяет, что метод compareAverages обрабатывает большие списки
     */
    @Test
    @DisplayName(" Проверка, что метод compareAverages обрабатывает большие списки")
    void compareAveragesShouldHandleLargeLists() {
        List<Integer> list1 = Collections.nCopies(500, 10);
        List<Integer> list2 = Collections.nCopies(1000, 5);

        ListAverageComparator comparator = new ListAverageComparator(list1, list2);

        String expectedOutput = "Первый список имеет большее среднее значение - 10.0";

        assertDoesNotThrow(() -> {
            String actualOutput = getOutput(comparator::compareAverages);
            assertEquals(expectedOutput.trim(), actualOutput.trim());
        });
    }


    // Вспомогательный метод для перехвата вывода в строку
    private String getOutput(Runnable runnable) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalOut = System.out;

        System.setOut(printStream);
        runnable.run();
        System.out.flush();
        System.setOut(originalOut);

        return outputStream.toString();
    }
}
