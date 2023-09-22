package hw4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryBookRepository implements BookRepository {
    private final Map<String, Book> books = new HashMap<>();

    public InMemoryBookRepository() {
        this.books.put("1", new Book("1", "Book1", "Author1"));
        this.books.put("2", new Book("2", "Book2", "Author2"));
    }

    public Book findById(String id) {
        return (Book)this.books.get(id);
    }

    public List<Book> findAll() {
        return new ArrayList<>(this.books.values());
    }

}
