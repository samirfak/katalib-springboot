package fr.codebusters.libkata.repository;

import fr.codebusters.libkata.Model.Book;
import fr.codebusters.libkata.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    List<Book> findByCategory(Category category);
    List<Book> findByAuthor(String author);
}
