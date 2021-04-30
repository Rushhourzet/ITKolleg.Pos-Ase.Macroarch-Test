package at.itkollegimst.hampl.pos1makro.test2.domainbookshop.orderdomain.domain.abstractions;

import at.itkollegimst.hampl.pos1makro.test2.domainbookshop.bookdomain.domain.abstraction.Product;
import at.itkollegimst.hampl.pos1makro.test2.domainbookshop.orderdomain.domain.components.LineItem;
import at.itkollegimst.hampl.pos1makro.test2.domainbookshop.orderdomain.domain.components.OrderStatus;
import at.itkollegimst.hampl.pos1makro.test2.domainbookshop.userdomain.domain.entities.User;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
public class Order {

    @Id
    @GeneratedValue
    private long id;
    private long user;
    private Collection<LineItem> shopList;
    private OrderStatus status;
    private Date orderTime;


    public Order(long user, Collection<LineItem> shopList, OrderStatus status) {
        this.user = user;
        this.shopList = shopList;
        this.status = status;
    }

    public Order() {

    }
}
