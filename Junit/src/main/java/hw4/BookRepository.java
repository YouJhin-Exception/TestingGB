package hw4;

import java.util.List;

public interface BookRepository {
    Book findById(String var1);

    List<Book> findAll();

}
