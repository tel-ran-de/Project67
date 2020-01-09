package de.telran.blog.dto;

import de.telran.blog.entity.PostEntity;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Data
public class PostDto {

    public PostDto() {
    }

    public PostDto(PostEntity postEntity) {
        this.body = postEntity.getBody();
        this.id = postEntity.getId();
        this.title = postEntity.getTitle();
        this.localDate = postEntity.getLocalDate();
    }

    private Long id;
    private String title;
    private String body;
    private LocalDate localDate;
   // private Date date;
    private Long authorId;
}
