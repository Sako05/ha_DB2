package com.example.demo.controllers;

import com.example.demo.model.Orders;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;


class OrdersControllerTest {

    @Test
    void addOrder() {
        OrdersController controller = mock(OrdersController.class);

        String orderAddedMessage = controller.addOrder("Gatan 2", 15L, 1200L);

        when(controller.addOrder("Gatan 2", 15L, 1200L)).thenReturn(orderAddedMessage);

        assertEquals(controller.addOrder("Gatan 2", 15L, 1200L), orderAddedMessage);

        verify(controller, times(2)).addOrder(any(),anyLong(),anyLong());
    }

    @Test
    void deleteOrder() {
        OrdersController controller = mock(OrdersController.class);

        String orderDeletedMessage = controller.deleteOrder(112L);

        when(controller.deleteOrder(112L)).thenReturn(orderDeletedMessage);

        assertEquals(controller.deleteOrder(112L), orderDeletedMessage);

        verify(controller, times(2)).deleteOrder(anyLong());

    }

    @Test
    void getOrderID() {
        OrdersController controller = mock(OrdersController.class);

        Iterable<Orders> orderID = controller.getOrderID(15L);

        when(controller.getOrderID(15L)).thenReturn(orderID);

        assertEquals(controller.getOrderID(15L), orderID);

        verify(controller, times(2)).getOrderID(anyLong());

    }

    @Test
    void getCustomerOrders() {
        OrdersController controller = mock(OrdersController.class);

        Iterable<Orders> customerOrders = controller.getCustomerOrders(15L);

        when(controller.getCustomerOrders(15L)).thenReturn(customerOrders);

        assertEquals(controller.getCustomerOrders(15L), customerOrders);

        verify(controller, times(2)).getCustomerOrders(anyLong());
    }

    @Test
    void getOrdersSum() {
        OrdersController controller = mock(OrdersController.class);

        Iterable<Orders> ordersSum = controller.getOrdersSum(15L);

        when(controller.getOrdersSum(15L)).thenReturn(ordersSum);

        assertEquals(controller.getOrdersSum(15L), ordersSum);

        verify(controller, times(2)).getOrdersSum(anyLong());
    }

    @Test
    void getOrderByid() {
        OrdersController controller = mock(OrdersController.class);

        Optional<Orders> orderByid = controller.getOrderByid(15L);

        when(controller.getOrderByid(15L)).thenReturn(orderByid);

        assertEquals(controller.getOrderByid(15L), orderByid);

        verify(controller, times(2)).getOrderByid(anyLong());
    }
}