package com.example.demo.controllers;

import com.example.demo.model.Orders;
import com.example.demo.model.Product;
import com.example.demo.repositories.ProductRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductControllerTest {


    @Test
    void addProductWithCategory() {
        ProductRepository productRepository = mock(ProductRepository.class);

        ProductController controller = mock(ProductController.class);

        String message = controller.addProductWithCategory("ProductName", 100L, "Fin", "url.com", 1L, "1");

        when(controller.addProductWithCategory("ProductName",100L,"Fin","url.com",1L, "1")).thenReturn(message);

        assertEquals(controller.addProductWithCategory("ProductName",100L,"Fin","url.com",1L, "1"), message);

        verify(controller, times(2)).addProductWithCategory(any(),anyLong(),any(),any(),anyLong(),any());

    }

    @Test
    void updateProductWithCategory() {
        ProductController controller = mock(ProductController.class);
        String message = controller.updateProductWithCategory("15","ProductName", 100L, "Fin", 1L);

        when(controller.updateProductWithCategory("15","productName", 100L,"Fin", 1L)).thenReturn(message);

        assertEquals(controller.updateProductWithCategory("15","productName", 100L,"Fin", 1L), message);

        verify(controller, times(2)).updateProductWithCategory(any(),any(),anyLong(),any(),anyLong());

    }


    @Test
    void getProductByID() {
        ProductController controller = mock(ProductController.class);
        Product productByID = controller.getProductByID(15);

        when(controller.getProductByID(15)).thenReturn(productByID);

        assertEquals(controller.getProductByID(15), productByID);

        verify(controller, times(2)).getProductByID(anyInt());

    }

    @Test
    void updateName() {
        ProductController controller = mock(ProductController.class);
        String updateName = controller.updateName("15", "newName");

        when(controller.updateName("15", "newName")).thenReturn(updateName);

        assertEquals(controller.updateName("15", "newName"), updateName);

        verify(controller, times(2)).updateName(anyString(),anyString());

    }

    @Test
    void updatePrice() {
        ProductController controller = mock(ProductController.class);
        String updatePrice = controller.updatePrice("15", 500);

        when(controller.updatePrice("15", 500)).thenReturn(updatePrice);

        assertEquals(controller.updatePrice("15", 500), updatePrice);

        verify(controller, times(2)).updatePrice(anyString(), anyInt());

    }

    @Test
    void updateDescription() {
        ProductController controller = mock(ProductController.class);
        String updateDescription = controller.updateDescription("15", "Ny beskrivning");

        when(controller.updateDescription("15", "Ny beskrivning")).thenReturn(updateDescription);

        assertEquals(controller.updateDescription("15", "Ny beskrivning"), updateDescription);

        verify(controller, times(2)).updateDescription(anyString(),anyString());

    }

    @Test
    void updateImageURL() {
        ProductController controller = mock(ProductController.class);
        String updateImageURL = controller.updateImageURL("15", "NyURL");

        when(controller.updateImageURL("15", "NyURL")).thenReturn(updateImageURL);

        assertEquals(controller.updateImageURL("15", "NyURL"), updateImageURL);

        verify(controller, times(2)).updateImageURL(anyString(),anyString());

    }

    @Test
    void getOrderID() {
        ProductController controller = mock(ProductController.class);
        Iterable<Product> orderID = controller.getOrderID(15L);

        when(controller.getOrderID(15L)).thenReturn(orderID);

        assertEquals(controller.getOrderID(15L), orderID);

        verify(controller, times(2)).getOrderID(anyLong());


    }


    @Test
    void customerOrders() {
        ProductController controller = mock(ProductController.class);
        Iterable<Product> allCustomersOrders = controller.CustomerOrders(15L);

        when(controller.CustomerOrders(15L)).thenReturn(allCustomersOrders);

        assertEquals(controller.CustomerOrders(15L), allCustomersOrders);

        verify(controller, times(2)).CustomerOrders(anyLong());

    }

    @Test
    void updateQuantity() {
        ProductController controller = mock(ProductController.class);
        String updatedQuantity = controller.updateQuantity("15", 1000);

        when(controller.updateQuantity("15", 1000)).thenReturn(updatedQuantity);

        assertEquals(controller.updateQuantity("15", 1000), updatedQuantity);
        verify(controller, times(2)).updateQuantity(anyString(), anyInt());

    }
}