package hw2;

import hw2.abstracts.Vehicle;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class VehicleTest {
    private Car car;
    private Motorcycle motorcycle;

    @BeforeEach
    void setUp() {
        car = new Car("Mazda", "Axela", 2020);
        motorcycle = new Motorcycle("Honda", "EVO-6", 2021);
    }

    @Test
    @DisplayName("Проверить, что экземпляр объекта Car также является экземпляром транспортного средства")
    public void testCarIsInstanceOfVehicle() {
        assertTrue(car instanceof Vehicle);
    }

    @Test
    @DisplayName("Проверить, что объект Car создается с 4-мя колесами.")
    public void testCarHasFourWheels() {
        assertEquals(4, car.getNumWheels());
    }

    @Test
    @DisplayName("Проверить, что объект Car развивает скорость 60 в режиме тестового вождения")
    public void testCarSpeed() {
        car.testDrive();
        assertEquals(60, car.getSpeed());
    }

    @Test
    @DisplayName("Проверить, что в режиме парковки машина останавливается (speed = 0).")
    public void testCarPark() {
        car.testDrive();
        car.park();
        assertEquals(0, car.getSpeed());
    }

    @Test
    @DisplayName("Проверить, что объект Motorcycle создается с 2-мя колесами.")
    public void testMotorcycleHasTwoWheels() {
        assertEquals(2, motorcycle.getNumWheels());
    }

    @Test
    @DisplayName("Проверить, что объект Motorcycle развивает скорость 75 в режиме тестового вождения")
    public void testMotorcycleSpeed() {
        motorcycle.testDrive();
        assertEquals(75, motorcycle.getSpeed());
    }

    @Test
    @DisplayName("Проверить, что в режиме парковки мотоцикл останавливается (speed = 0)")
    public void testMotorcyclePark() {
        motorcycle.testDrive();
        motorcycle.park();
        assertEquals(0, motorcycle.getSpeed());
    }

    /* тестил с параметрами, эта штука тут недопустима потому что отрабатывает как foreach
       т.е. дает и машине и мотоциклу сначала по 60 и во 2й итерации по 75 и соответственно тесты падают
     */

//    @ParameterizedTest
//    @ValueSource(ints = {60,75})
//    @DisplayName("Проверить, что скорость транспортного средства соответствует ожидаемой скорости")
//    void testVehicleSpeed(int expectedSpeed) {
//        car.testDrive();
//        motorcycle.testDrive();
//
//       System.out.println(car.getSpeed());
//       System.out.println(motorcycle.getSpeed());
//
//        // Проверяем скорость для каждого транспортного средства
//        assertEquals(expectedSpeed, car.getSpeed());
//        assertEquals(expectedSpeed, motorcycle.getSpeed());
//    }

}