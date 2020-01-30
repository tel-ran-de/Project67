package de.telran.blog.controller;

import de.telran.blog.dto.TagsDto;
import de.telran.blog.entity.TagsEntity;
import de.telran.blog.service.TagsService;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class TagsControllerUnitTest {

    @Test
    void createNewTag() {

        TagsService tagsService = Mockito.mock(TagsService.class);

        when(tagsService.createTag( any())).thenReturn(1L);

        TagsController tagsController = new TagsController(tagsService);

        TagsEntity tagsEntity = new TagsEntity();
        tagsEntity.setText("Wetter");
        tagsEntity.setDescription("Wettertag");

        TagsDto tagsDto = new TagsDto(tagsEntity);


        Long result = tagsController.createNewTag(tagsDto);

        assertEquals(1, result);
    }

    @Test
    void getTag() {

        TagsService tagsService = Mockito.mock(TagsService.class);
        TagsEntity tagsEntity = new TagsEntity();
        tagsEntity.setText("Java");
        tagsEntity.setDescription("Alles rund um Java");
        tagsEntity.setId(2L);

        when(tagsService.getTagForId( 2L )).thenReturn(tagsEntity);

        TagsController tagsController = new TagsController(tagsService);
        TagsDto tagsDto = tagsController.getTag(2L);

        assertEquals(  "Alles rund um Java", tagsDto.getDescription() );
        assertEquals( "Java", tagsDto.getText() );
        assertEquals( 2 , tagsDto.getId());
    }

    @Test
    void getAllTags() {

        TagsService tagsService = Mockito.mock(TagsService.class);

        TagsEntity tagOne = new TagsEntity();
        tagOne.setText("Java");
        tagOne.setDescription("Alles rund um Java");
        tagOne.setId(2L);

        TagsEntity tagTwo = new TagsEntity();
        tagTwo.setText("Tree");
        tagTwo.setDescription("WaldTag");
        tagTwo.setId(3L);

        TagsEntity tagThree = new TagsEntity();
        tagThree.setText("Wetter");
        tagThree.setDescription("Das ist ein Wettertag");
        tagThree.setId(1L);

        List<TagsEntity> tagList = Arrays.asList( tagOne, tagTwo, tagThree);

        when( tagsService.getAllTags()).thenReturn(tagList);

        TagsController tagsController = new TagsController(tagsService);

        List<TagsDto> tagsDtoList= tagsController.getAllTags();

        assertEquals( tagsDtoList.get(0), new TagsDto(tagList.get(0)) );
        assertEquals( tagsDtoList.get(1), new TagsDto(tagList.get(1)) );
        assertEquals( tagsDtoList.get(2), new TagsDto(tagList.get(2)));
    }
}
