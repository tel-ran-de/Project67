package de.telran.blog.entity;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "authorEntity")
    private Set<PostEntity> postEntities;
}
