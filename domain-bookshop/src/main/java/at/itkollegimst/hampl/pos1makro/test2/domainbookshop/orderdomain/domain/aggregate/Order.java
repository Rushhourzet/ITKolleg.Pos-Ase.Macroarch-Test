package at.itkollegimst.hampl.pos1makro.test2.bookshop.domain.aggregate;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Order {

    @Id
    @GeneratedValue
    private long id;
    private String userName;
    private String userMail;
    private String bookName;

    public Order(String userName, String userMail, String bookName) {
        this.userName = userName;
        this.userMail = userMail;
        this.bookName = bookName;
    }

    public Order() {

    }
}
