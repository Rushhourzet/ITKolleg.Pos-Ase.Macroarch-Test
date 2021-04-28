package at.itkollegimst.hampl.pos1makro.test2.domain.domain.common.entities;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long bookId;
    private long userId;
    private Date date;
    private Time time;
}
