package de.telran.blog.service;
import de.telran.blog.dto.PostDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface IPostService {

    List<PostDto> findAllPage(int page, int size, String sortDir, String sort);

    Page<PostDto> findAllPage(Pageable pageable);

    List<PostDto> getPostsListByAuthor(int page, int size, String sortDir, String sort);

    PostDto createNewPost(PostDto post);

    PostDto getPostById(Long id);

    void updatePost(PostDto post);
}
