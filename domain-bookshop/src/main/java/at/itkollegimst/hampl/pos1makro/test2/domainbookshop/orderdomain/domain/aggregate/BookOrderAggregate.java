package at.itkollegimst.hampl.pos1makro.test2.domainbookshop.orderdomain.domain.aggregate;

import at.itkollegimst.hampl.pos1makro.test2.domainbookshop.bookdomain.domain.abstraction.Product;
import at.itkollegimst.hampl.pos1makro.test2.domainbookshop.bookdomain.domain.entities.Book;
import at.itkollegimst.hampl.pos1makro.test2.domainbookshop.orderdomain.domain.entities.BookOrder;
import at.itkollegimst.hampl.pos1makro.test2.domainbookshop.printingdomain.domain.entities.PrintJob;
import at.itkollegimst.hampl.pos1makro.test2.domainbookshop.userdomain.domain.entities.User;
import org.apache.tomcat.jni.Error;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.InvalidClassException;
import java.util.Collection;
import java.util.List;

public class BookOrderAggregate {
    private BookOrder order;
    private User user;
    private Collection<Book> items;
    private List<Error> error;

    public BookOrderAggregate() {
    }

    public BookOrderAggregate withExistingUserByName(String name){
        if(user != null) {
            //retrieve and validate user
            //this.user = validatedUser;
        }
        else{
            this.error.add(new Error("withExistingUserByName was given null"));
        }
        return this;
    }

    public BookOrderAggregate createNewUser(String fullname, String email){
        if(fullname == null || email == null || fullname.isEmpty() || email.isEmpty()){
            this.error.add( new Error("Either the given name or email are null or empty"));
        }else{
            this.user = new User(fullname, email); //needs to be moved into userms as soon as its done
        }
        return this;
    }

    public BookOrderAggregate addBooksToOrderByNameAndQuantity(String name, int quantity){
        if(name == null ||name.isEmpty()){
            this.error.add(new Error("The parameter name in addBooksToOrderBynameAndQuantity was null or empty"));
        }else{
            //Check if book with name exists
            //if book does not exist add error
            //else
            //add book to items
            //add the book to the order by id with an index
        }
        return this;
    }

    public List<Error> saveOrder(BookOrderAggregate order) throws Exception {
        if(this.error.isEmpty()){
            //validate if order is complete
            //save order into database and start processing
            return null;
        }
        else{
            return this.error;
        }
    }
}
