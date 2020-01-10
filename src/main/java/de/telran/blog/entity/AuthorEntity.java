package de.telran.blog.entity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "author_entity")
public class AuthorEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
}
