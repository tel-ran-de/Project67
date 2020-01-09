package de.telran.blog.dto;

import de.telran.blog.entity.PostEntity;
import lombok.*;
import java.time.LocalDate;

@Data
public class PostDto {

    public PostDto() {
    }

    public PostDto(PostEntity postEntity) {
        this.body = postEntity.getBody();
        this.id = postEntity.getId();
        this.title = postEntity.getTitle();
        this.date = postEntity.getDate();
    }

    private Long id;
    private String title;
    private String body;
    private LocalDate date;
    private Long authorId;
}
