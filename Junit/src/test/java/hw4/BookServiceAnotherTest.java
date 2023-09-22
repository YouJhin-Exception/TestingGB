package hw4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class BookServiceAnotherTest {
    private static final String TEST_BOOK_ID = "123";
    private static final String TEST_BOOK_TITLE = "Test Book";
    private static final String TEST_BOOK_AUTHOR = "Test Author";

    private BookRepository mockRepository;
    private BookService bookService;

    /**
     * Подготовка перед каждым тестом: создание мок-объекта BookRepository и экземпляра BookService.
     */
    @BeforeEach
    public void setUp() {
        mockRepository = Mockito.mock(BookRepository.class);
        bookService = new BookService(mockRepository);
    }

    /**
     * Тест метода findBookById.
     */
    @Test
    public void testFindBookById() {
        // Arrange
        Book expectedBook = new Book(TEST_BOOK_ID, TEST_BOOK_TITLE, TEST_BOOK_AUTHOR);
        when(mockRepository.findById(TEST_BOOK_ID)).thenReturn(expectedBook);

        // Act
        Book result = bookService.findBookById(TEST_BOOK_ID);

        // Assert
        assertEquals(TEST_BOOK_TITLE, result.getTitle());
        assertEquals(TEST_BOOK_AUTHOR, result.getAuthor());
    }

    /**
     * Тест метода findAllBooks.
     */
    @Test
    public void testFindAllBooks() {
        // Arrange
        Book expectedBook = new Book(TEST_BOOK_ID, TEST_BOOK_TITLE, TEST_BOOK_AUTHOR);
        when(mockRepository.findAll()).thenReturn(Collections.singletonList(expectedBook));

        // Act
        List<Book> result = bookService.findAllBooks();

        // Assert
        assertEquals(1, result.size());
        assertEquals(TEST_BOOK_TITLE, result.get(0).getTitle());
        assertEquals(TEST_BOOK_AUTHOR, result.get(0).getAuthor());
    }
}
