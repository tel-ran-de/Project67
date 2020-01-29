package de.telran.blog.controller;

import de.telran.blog.dto.TagsDto;
import de.telran.blog.entity.TagsEntity;
import de.telran.blog.service.TagsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tags")
@Slf4j
public class TagsController {

    private final TagsService tagsService;

    public TagsController( TagsService tagsService) {
        this.tagsService = tagsService;
    }

    @PostMapping
    public Long createNewTag(@RequestBody TagsDto tagsDto) {
        log.info("Request received. tagDto={}", tagsDto);


        return tagsService.createTag(convertToEntity(tagsDto));
    }

    @GetMapping("/{id}")
    public TagsDto getTag(@PathVariable Long id ){
        return new TagsDto(tagsService.getTagForId(id));
    }

    @GetMapping
    public List<TagsDto> getAllTags() {
        return tagsService.getAllTags()
                .stream()
                .map(TagsDto::new)
                .collect(Collectors.toList());
    }

    private TagsEntity convertToEntity(TagsDto tagsDto){
        TagsEntity tagsEntity = new TagsEntity();
        tagsEntity.setDescription(tagsDto.getDescription());
        tagsEntity.setText(tagsDto.getText());


        return tagsEntity;
    }


}

