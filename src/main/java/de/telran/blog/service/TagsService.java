package de.telran.blog.service;

import de.telran.blog.entity.TagsEntity;
import de.telran.blog.repository.TagsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagsService implements ITagsService {

    private final TagsRepository tagsRepository;

    public TagsService(TagsRepository tagsRepository){
        this.tagsRepository = tagsRepository;
    }


    public Long createTag(TagsEntity tagsEntity ) {

        return tagsRepository.save(tagsEntity).getId();
    }

    public List<TagsEntity> getAllTags() {
        return tagsRepository.findAll()
                .stream()
                .collect(Collectors.toList());
    }

    public TagsEntity getTagForId( Long tagId  ) {
        return tagsRepository.findById(tagId).orElseThrow(() ->  new IllegalStateException("Id " + tagId + " not found"));
    }
}
