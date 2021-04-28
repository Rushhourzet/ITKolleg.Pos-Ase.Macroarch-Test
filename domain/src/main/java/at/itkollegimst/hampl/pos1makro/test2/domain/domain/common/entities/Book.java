package at.itkollegimst.hampl.pos1makro.test2.domain.domain.common.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.domain.AbstractAggregateRoot;

import lombok.Data;

@Data
public class Book{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String content;
    
}
