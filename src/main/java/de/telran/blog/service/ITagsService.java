package de.telran.blog.service;

import de.telran.blog.entity.TagsEntity;

import java.util.List;

public interface ITagsService {

    Long createTag(TagsEntity tagsEntity );

    List<TagsEntity> getAllTags();


    TagsEntity getTagForId(Long tagId);

}
