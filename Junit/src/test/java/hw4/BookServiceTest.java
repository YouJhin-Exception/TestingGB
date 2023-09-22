package hw4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * Юнит-тесты для класса BookService, использующие Mockito для создания мок-объекта BookRepository.
 */
class BookServiceTest {
    @Mock
    private BookRepository bookRepository;

    private BookService bookService;

    /**
     * Инициализация мок-объекта и создание экземпляра BookService перед каждым тестом.
     */
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        bookService = new BookService(bookRepository);
    }

    /**
     * Тест для метода findBookById.
     */
    @Test
    public void testFindBookById() {
        // Arrange
        String bookId = "123";
        Book expectedBook = new Book(bookId, "Test Book","Author");
        when(bookRepository.findById(bookId)).thenReturn(expectedBook);

        // Act
        Book actualBook = bookService.findBookById(bookId);

        // Assert
        assertEquals(expectedBook, actualBook);
    }

    /**
     * Тест для метода findAllBooks.
     */
    @Test
    public void testFindAllBooks() {
        // Arrange
        List<Book> expectedBooks = new ArrayList<>();
        expectedBooks.add(new Book("1", "Book 1","Author1"));
        expectedBooks.add(new Book("2", "Book 2","Author2"));
        when(bookRepository.findAll()).thenReturn(expectedBooks);

        // Act
        List<Book> actualBooks = bookService.findAllBooks();

        // Assert
        assertEquals(expectedBooks, actualBooks);
    }

}