package fr.codebusters.libkata.repository;

import fr.codebusters.libkata.model.Book;
import fr.codebusters.libkata.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    List<Book> findByCategory(Category category);
    List<Book> findByAuthor(String author);
}
