package de.telran.blog.repository;

import de.telran.blog.entity.PostEntity;
import de.telran.blog.entity.TagsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagsRepository extends JpaRepository<TagsEntity, Long> {
}
