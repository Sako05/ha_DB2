package com.example.demo.controllers;

import com.example.demo.model.Category;
import com.example.demo.repositories.CategoryRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategoryControllerTest {

    @Test
    void addNewCategory() {

        CategoryController controller = mock(CategoryController.class);
        CategoryRepository categoryRepository = mock(CategoryRepository.class);

        String newCategoryMessage = controller.addNewCategory("Frukt");

        when(controller.addNewCategory("Frukt")).thenReturn(newCategoryMessage);

        assertEquals(controller.addNewCategory("Frukt"),newCategoryMessage);

        verify(controller,times (2)).addNewCategory("Frukt");

    }

    @Test
    void getCategoryByID() {

        CategoryController controller = mock(CategoryController.class);
        CategoryRepository categoryRepository = mock(CategoryRepository.class);

        Category category = controller.getCategoryByID(15);
        Iterable<Category> allCategories = categoryRepository.findAll();

        when(categoryRepository.findAll()).thenReturn(allCategories);
        when(controller.getCategoryByID(15)).thenReturn(category);

        assertEquals(controller.getCategoryByID(15),category);

        verify(controller, times(2)).getCategoryByID(15);
        verify(categoryRepository).findAll();

    }

    @Test
    void updateName() {

        CategoryController controller = mock(CategoryController.class);

        String updateNameMessage = controller.updateName(15, "nyttNamn");

        when(controller.updateName(15, "nyttNamn")).thenReturn(updateNameMessage);

        assertEquals(controller.updateName(15, "nyttNamn"), updateNameMessage);

        verify(controller,times(2)).updateName(anyInt(), any());
    }

    @Test
    void deleteCategory() {

        CategoryController controller = mock(CategoryController.class);

        String deleteCategoryMessage = controller.deleteCategory(15);

        when(controller.deleteCategory(15)).thenReturn(deleteCategoryMessage);

        assertEquals(controller.deleteCategory(15),deleteCategoryMessage);

        verify(controller,times(2)).deleteCategory(anyInt());
    }

    @Test
    void categoryForProduct() {
        CategoryRepository categoryRepository = mock(CategoryRepository.class);
        CategoryController controller = mock(CategoryController.class);

        Iterable<Category> categories = controller.CategoryForProduct(15L);

        when(categoryRepository.findCategoryByProductID(15L)).thenReturn(categories);
        when(controller.CategoryForProduct(15L)).thenReturn(categories);

        assertEquals(categoryRepository.findCategoryByProductID(15L),categories);

        verify(categoryRepository).findCategoryByProductID(any());
        verify(controller).CategoryForProduct(any());
    }

    @Test
    void remove() {
        final CategoryController controller = mock(CategoryController.class);
        final CategoryRepository categoryRepository = mock(CategoryRepository.class);
        final boolean categoryIsRemoved = controller.remove(15);

        Iterable<Category> allCategories = categoryRepository.findAll();

        when(controller.remove(15)).thenReturn(categoryIsRemoved);
        when(categoryRepository.findAll()).thenReturn(allCategories);

        assertEquals(controller.remove(15), categoryIsRemoved);

        verify(controller,times(2)).remove(anyInt());
        verify(categoryRepository).findAll();
        verify(controller,times(2)).remove(15);
    }
}