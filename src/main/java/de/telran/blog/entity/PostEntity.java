package de.telran.blog.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "POST")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String body;
    @Column(name="LOCAL_DATE", columnDefinition = "DATE")
    private LocalDate localDate;
    @ManyToOne(targetEntity = AuthorEntity.class)
    @JoinColumn(name="AUTHOR_ID")
    private AuthorEntity authorEntity;
}
