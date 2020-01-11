package de.telran.blog.entity;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;


@Entity(name = "post_entity")
@Table(schema = "blog")
@Data
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "body", nullable = false)
    private String body;
    @Column(name = "date", nullable = false)
    private LocalDate date;
    @JoinColumn(name = "author_entity_id", nullable = false)
    @ManyToOne(targetEntity = AuthorEntity.class)
    private AuthorEntity authorEntity;
}
