package de.telran.blog.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "author_entity")
@Table(schema = "blog")
@Data
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name = "id", nullable = false)
    private Long id;
    @JoinColumn(name = "first_Name", nullable = false)
    private String firstName;
    @JoinColumn(name = "last_Name", nullable = false)
    private String lastName;
}
