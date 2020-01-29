package de.telran.blog.integration;

import de.telran.blog.dto.TagsDto;
import de.telran.blog.entity.AuthorEntity;
import de.telran.blog.entity.TagsEntity;
import de.telran.blog.repository.AuthorRepository;
import de.telran.blog.repository.TagsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import javax.transaction.Transactional;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)

public class TagsControllerTest {
    TestRestTemplate restTemplate = new TestRestTemplate();

    @Autowired
    TagsRepository tagsRepository;

    @Transactional
    @Test
    void createNewTag() throws URISyntaxException {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");

        RequestEntity<String> requestEntity = new RequestEntity<>(
                "{ \"text\": \"wetter\", \"description\": \"tags  wetter\" }",
                httpHeaders,
                HttpMethod.POST,
                new URI("http://localhost:8080/api/tags")
        );

        ResponseEntity<String> responseEntity = restTemplate.exchange(
                requestEntity,
                String.class
        );

        long newTagsId = Long.parseLong(responseEntity.getBody());

        TagsEntity tagsEntity = tagsRepository.getOne(newTagsId);

        assertEquals("wetter", tagsEntity.getText());
        assertEquals("tags  wetter", tagsEntity.getDescription());
    }

    @Transactional
    @Test
    void getTagById() throws URISyntaxException {


        HttpHeaders httpHeaders = new HttpHeaders();
        // httpHeaders.add("Content-Type", "application/json");

        RequestEntity<String> requestEntity = new RequestEntity<>(

                httpHeaders,
                HttpMethod.GET,
                new URI("http://localhost:8080/api/tags/1")
        );

        ResponseEntity<TagsDto> responseEntity = restTemplate.exchange(
                requestEntity,
                TagsDto.class
        );

        TagsDto tagsDto = responseEntity.getBody();

        assertEquals("Wetter", tagsDto.getText());
        assertEquals("Das ist ein Wettertag", tagsDto.getDescription());
    }

    @Transactional
    @Test
    void getAllTags() throws URISyntaxException {
        HttpHeaders httpHeaders = new HttpHeaders();

        RequestEntity<TagsDto[]> requestEntity = new RequestEntity<>(

                httpHeaders,
                HttpMethod.GET,
                new URI("http://localhost:8080/api/tags/")
        );

        ResponseEntity<TagsDto[]> responseEntity = restTemplate.exchange(
                requestEntity,
                TagsDto[].class
        );


        TagsDto[] tagsDtos = responseEntity.getBody();
        assertEquals( 3, tagsDtos.length );

        assertEquals( "Wetter", tagsDtos[0].getText());
        assertEquals( "Java", tagsDtos[1].getText());
        assertEquals( "Tree", tagsDtos[2].getText());
    }
}
