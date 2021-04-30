package at.itkollegimst.hampl.pos1makro.test2.domainbookshop.userdomain.domain.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String name;
    public String mail;

    public User(String name, String mail) {
        this.name = name;
        this.mail = mail;
    }

    public User() {

    }
}
