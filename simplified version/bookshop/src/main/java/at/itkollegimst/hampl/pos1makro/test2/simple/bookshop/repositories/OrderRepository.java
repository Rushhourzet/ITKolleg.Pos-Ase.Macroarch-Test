package at.itkollegimst.hampl.pos1makro.test2.simple.bookshop.repositories;

import at.itkollegimst.hampl.pos1makro.test2.simple.bookshop.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Collection<Order> findByBookName(String bookName);
}

