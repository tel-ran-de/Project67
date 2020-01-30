package de.telran.blog.service;

import de.telran.blog.entity.TagsEntity;
import de.telran.blog.repository.TagsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class TagsServiceTest {

    @Autowired
    private TagsService tagsService;



    @Test
    void testCreateTagWithTextAndDescription_pass() {

        TagsEntity tagsEntity = new TagsEntity();
        tagsEntity.setText("Java");
        tagsEntity.setDescription("Java Tags");


        Long id = tagsService.createTag(tagsEntity);

        assertEquals(4L, id);
    }
}
