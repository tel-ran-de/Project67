package de.telran.blog.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Table(name = "tags")
@Data
@Entity
public class TagsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "text")
    private String text;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "tagsEntity")
    private Set<PostEntity> postEntity;
}
