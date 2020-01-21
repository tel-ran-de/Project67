package de.telran.blog.service;

import de.telran.blog.dto.TagsDto;
import de.telran.blog.entity.TagsEntity;
import de.telran.blog.repository.TagsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagsService {

    private TagsRepository tagsRepository;

    public TagsService(TagsRepository tagsRepository){
        this.tagsRepository = tagsRepository;
    }

    public Long createTag(TagsDto dto ) {
        TagsEntity tagsEntity = new TagsEntity();
        tagsEntity.setText(dto.getText());
        tagsEntity.setDescription(dto.getDescription());

        return tagsRepository.save(tagsEntity).getId();
    }

    public List<TagsDto> getAllTags() {
        return tagsRepository.findAll()
                .stream()
                .map(TagsDto::new)
                .collect(Collectors.toList());
    }

    public TagsDto getDto( Long tagId  ) {
        return new TagsDto(tagsRepository.findById(tagId)
                .orElseThrow(
                        () -> new RuntimeException("Tag with id=" + tagId + "not found")
                ));
    }
}
