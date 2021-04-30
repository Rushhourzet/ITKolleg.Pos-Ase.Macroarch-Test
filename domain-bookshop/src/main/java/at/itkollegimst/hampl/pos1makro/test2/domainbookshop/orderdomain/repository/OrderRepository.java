package at.itkollegimst.hampl.pos1makro.test2.bookshop.repository;

import at.itkollegimst.hampl.pos1makro.test2.bookshop.domain.aggregate.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Collection<Order> findByBookName(String bookName);
}

