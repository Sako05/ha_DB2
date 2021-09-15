package com.example.demo.controllers;

import com.example.demo.model.Order_Row;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class Order_RowControllerTest {

    @Test
    void addOrderRow() {
        Order_RowController controller = mock(Order_RowController.class);

        String isSavedMessage = controller.AddOrderRow(15L,120L, 1L);

        when(controller.AddOrderRow(15L,120L, 1L)).thenReturn(isSavedMessage);

        assertEquals(controller.AddOrderRow(15L,120L, 1L), isSavedMessage);

        verify(controller, times(2)).AddOrderRow(anyLong(),anyLong(),anyLong());

    }

    @Test
    void getOrderWithProduct() {
        Order_RowController controller = mock(Order_RowController.class);

        Iterable<Order_Row> orderWithProduct = controller.getOrderWithProduct(120L);

        when(controller.getOrderWithProduct(120L)).thenReturn(orderWithProduct);

        assertEquals(controller.getOrderWithProduct(120L), orderWithProduct);

        verify(controller, times(2)).getOrderWithProduct(anyLong());


    }

    @Test
    void deleteProduct() {
        Order_RowController controller = mock(Order_RowController.class);

        String isDeletedMessage = controller.deleteProduct(15L);

        when(controller.deleteProduct(15L)).thenReturn(isDeletedMessage);

        assertEquals(controller.deleteProduct(15L), isDeletedMessage);

        verify(controller, times(2)).deleteProduct(anyLong());

    }
}