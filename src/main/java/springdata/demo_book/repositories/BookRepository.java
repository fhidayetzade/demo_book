package springdata.demo_book.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springdata.demo_book.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
