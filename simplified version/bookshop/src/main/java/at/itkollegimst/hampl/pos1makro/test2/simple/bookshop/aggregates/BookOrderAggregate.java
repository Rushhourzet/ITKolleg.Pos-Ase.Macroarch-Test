package at.itkollegimst.hampl.pos1makro.test2.simple.bookshop.aggregates;


import at.itkollegimst.hampl.pos1makro.test2.simple.bookshop.components.LineItem;
import at.itkollegimst.hampl.pos1makro.test2.simple.bookshop.entities.Order;
import at.itkollegimst.hampl.pos1makro.test2.simple.bookshop.entities.User;
import at.itkollegimst.hampl.pos1makro.test2.simple.bookshop.repositories.BookRepository;
import at.itkollegimst.hampl.pos1makro.test2.simple.bookshop.repositories.OrderRepository;
import at.itkollegimst.hampl.pos1makro.test2.simple.bookshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.util.Collection;

public class BookOrderAggregate{
    @Autowired
    private OrderRepository orderRepository;
    private final Order order;
    private final Collection<LineItem> books;
    private final User user;


    public BookOrderAggregate(Order order, Collection<LineItem> books, User user) {
        if(order != null && books != null && !books.isEmpty() && user != null){
            this.order = order;
            this.books = books;
            this.user = user;
        } else{
            throw new IllegalArgumentException("Could not create BookOrderAggregate, since one of its parameters is null or empty");
        }
    }

    public boolean isDuplicateOrder(OrderRepository repo, Order order){
        return repo.existsById(order.getId());
    }

    public void save(){
        orderRepository.save(this.order);
    }
}
