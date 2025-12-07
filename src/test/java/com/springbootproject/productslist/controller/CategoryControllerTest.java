package com.springbootproject.productslist.controller;

import com.springbootproject.productslist.dto.CategoryDTO;
import com.springbootproject.productslist.service.CategoryService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class CategoryControllerTest {
    @InjectMocks
    private CategoryController categoryController;
    @Mock
    private CategoryService categoryService;

    // ye keval controller ke liye use hota hai because required method within
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(categoryController).build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void test_getAllCategories() throws Exception {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(1L);
        categoryDTO.setName("test");
        List <CategoryDTO> categoryList = List.of(categoryDTO);
        when(categoryService.getAllCategories()).thenReturn(categoryList);
        mockMvc.perform(get("/api/categories"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(categoryList.size()))
                .andExpect(jsonPath("$[0].name").value(categoryDTO.getName()));
    }
    @Test
    public void test_createCategory() throws Exception{
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(1L);
        categoryDTO.setName("test");
        when(categoryService.createCategory(any(CategoryDTO.class))).thenReturn(categoryDTO);
        mockMvc.perform(post("/api/categories")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n"+
                        "     \"id\": 1,\n" +
                        "      \"name\": \"test\"\n"+
                        "}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value(categoryDTO.getName()));


    }
}