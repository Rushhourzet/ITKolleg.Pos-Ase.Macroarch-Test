package at.itkollegimst.hampl.pos1makro.test2.simple.bookshop.services;

import at.itkollegimst.hampl.pos1makro.test2.simple.bookshop.aggregates.BookOrderAggregate;
import at.itkollegimst.hampl.pos1makro.test2.simple.bookshop.components.LineItem;
import at.itkollegimst.hampl.pos1makro.test2.simple.bookshop.entities.Book;
import at.itkollegimst.hampl.pos1makro.test2.simple.bookshop.entities.Order;
import at.itkollegimst.hampl.pos1makro.test2.simple.bookshop.entities.User;
import at.itkollegimst.hampl.pos1makro.test2.simple.bookshop.exceptions.InvalidUserNameException;
import at.itkollegimst.hampl.pos1makro.test2.simple.bookshop.exceptions.MoreThanOneUsersByThisParameterException;
import at.itkollegimst.hampl.pos1makro.test2.simple.bookshop.exceptions.UserDoesNotExistException;
import at.itkollegimst.hampl.pos1makro.test2.simple.bookshop.exceptions.UserException;
import at.itkollegimst.hampl.pos1makro.test2.simple.bookshop.repositories.BookRepository;
import at.itkollegimst.hampl.pos1makro.test2.simple.bookshop.repositories.OrderRepository;
import at.itkollegimst.hampl.pos1makro.test2.simple.bookshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class OrderService {
    private Collection<LineItem> books;
    private User user;
    private Order order;

    private UserRepository userRepository;
    private BookRepository bookRepository;
    private OrderRepository orderRepository;


    private int indexLineItem;


    public OrderService(){

    }

    public static OrderService StartNewOrder(){
        return new OrderService();
    }

    public OrderService asUserByUsername(String userName) throws UserException {
        if(userName.isEmpty() || userName == null){
            throw new InvalidUserNameException("The username cannot be null or empty");
        }else{
            validateUserByUsername(userName);
        }
        return this;
    }
    public OrderService addBook(String bookname, int count){
        Book book = bookRepository.findBookByName(bookname);
        //Errorchecking as done with User on books
        LineItem line = new LineItem(indexLineItem, count, book.getId());
        books.add(line);
        return this;
    }
    public void submit(){
        new BookOrderAggregate(order, books, user).save();
    }


    private User validateUserByUsername(String userName) throws UserDoesNotExistException, MoreThanOneUsersByThisParameterException {
        Collection<User> users = userRepository.getUsersByName(userName);
        if(users.isEmpty()){
            throw new UserDoesNotExistException("The user with the name \"" + userName+ "\" does not exist");
        }
        if(users.size()>1){
            throw new MoreThanOneUsersByThisParameterException("There are more than one users with the Username \"" + userName+ "\".");
        }
        return users.iterator().next();
    }

    public List<Order> listAllOrders() {
        //Should go through aggregate and not directly access orderRepo
        return orderRepository.findAll();
    }

    public void saveOrder(Order order) {
        //will throw an exception since it should not be possible to save without user or books
        new BookOrderAggregate(order, books, user).save();
    }
/*
    public Order getOrder(long id) {
        return orderRepository.findById(id).get();
    }

    public void deleteOrder(long id) {
        orderRepository.deleteById(id);
    }
 */
}