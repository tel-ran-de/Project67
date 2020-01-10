package de.telran.blog.controller;

import de.telran.blog.dto.PostDto;
import de.telran.blog.entity.PostEntity;
import de.telran.blog.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/posts")
@Slf4j
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class PagedController {
    private final PostRepository postRepository;

    public PagedController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/page")
    public Page<PostDto> loadPostsPage(@RequestParam(defaultValue = "0") int page) {
       return postRepository.findAllPage(PageRequest.of(page, 4)).map(PostDto::new);
    }

    @GetMapping("/sorted")
    public List<PostDto> loadPostsSorted(Sort sort) {
        return postRepository.findAllSorted(sort)
                .stream()
                .map(PostDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/slice")
    public Slice<PostDto> loadPostsSlice(@RequestParam(defaultValue = "0") int page) {
        return postRepository.findAllSlice(PageRequest.of(page, 4)).map(PostDto::new);
    }
}
