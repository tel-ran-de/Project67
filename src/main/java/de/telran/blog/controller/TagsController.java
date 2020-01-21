package de.telran.blog.controller;

import de.telran.blog.dto.PostDto;
import de.telran.blog.dto.TagsDto;
import de.telran.blog.service.TagsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return tagsService.createTag(tagsDto);
    }

    @GetMapping("/{id}")
    public TagsDto getTag(@PathVariable Long id ){
        return tagsService.getDto(id);
    }

    @GetMapping
    public List<TagsDto> getAllTags() {
        return tagsService.getAllTags();
    }
}

