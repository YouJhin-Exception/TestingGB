package hw3.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserRepositoryTest {

    private UserRepository userRepository;
    private User regularUser;
    private User adminUser;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepository();
        regularUser = new User("Sam", "pws1", false);
        adminUser = new User("Kate", "qwerty", true);
        regularUser.authenticate("Sam", "pws1");
        adminUser.authenticate("Kate", "qwerty");
        userRepository.addUser(regularUser);
        userRepository.addUser(adminUser);

    }

    @Test
    @DisplayName("Тест логаута НЕ админов")
    void logOutAllTest() {

        userRepository.logOutAll();
        assertFalse(regularUser.isAuthenticate);
        assertTrue(adminUser.isAuthenticate);

    }
}