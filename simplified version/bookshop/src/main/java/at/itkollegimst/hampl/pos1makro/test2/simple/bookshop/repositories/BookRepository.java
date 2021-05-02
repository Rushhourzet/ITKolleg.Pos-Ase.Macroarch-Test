package at.itkollegimst.hampl.pos1makro.test2.simple.bookshop.repositories;

import at.itkollegimst.hampl.pos1makro.test2.simple.bookshop.entities.Book;
import at.itkollegimst.hampl.pos1makro.test2.simple.bookshop.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findBookByName(String bookName);

}
