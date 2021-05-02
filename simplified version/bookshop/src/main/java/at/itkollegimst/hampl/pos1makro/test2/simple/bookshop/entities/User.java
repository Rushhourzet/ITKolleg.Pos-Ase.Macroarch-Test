package at.itkollegimst.hampl.pos1makro.test2.simple.bookshop.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//should not be here? should be substituted with an interface or abstract class
//And then create a user aggregate to create the user management business logic
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