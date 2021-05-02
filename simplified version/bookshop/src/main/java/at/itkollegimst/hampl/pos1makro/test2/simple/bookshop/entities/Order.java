package at.itkollegimst.hampl.pos1makro.test2.simple.bookshop.entities;

import at.itkollegimst.hampl.pos1makro.test2.simple.bookshop.components.LineItem;
import at.itkollegimst.hampl.pos1makro.test2.simple.bookshop.components.OrderStatus;
import lombok.Data;
import lombok.Getter;

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
    @SuppressWarnings("JpaAttributeTypeInspection")
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

    public long getId() {
        return this.id;
    }
    public long getUserId(){ return this.user;}
    public Collection<LineItem> getShopList(){return this.shopList;}
}
