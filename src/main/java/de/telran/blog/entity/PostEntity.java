package de.telran.blog.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "post_entity")
public class PostEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String body;
    private Date date;
    @ManyToOne(targetEntity = AuthorEntity.class)
    private AuthorEntity authorEntity;
}
