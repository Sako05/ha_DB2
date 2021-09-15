package com.example.demo.controllers;

import com.example.demo.model.Customer;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class CustomerControllerTest {

    @Autowired
    ProductRepository productRepositoryRepo;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Test
    void addCustomer() {
        CustomerController controller = mock(CustomerController.class);
        CustomerRepository customerRepository = mock(CustomerRepository.class);

        String isSavedMessage = controller
                .addCustomer("Anna", "Sten", "mail@gmail.com","pass", "Gatan 2",
                                11111L,"Stockholm", "15" );

        when(controller
                .addCustomer("Anna", "Sten", "mail@gmail.com","pass", "Gatan 2",
        11111L,"Stockholm", "15")).thenReturn(isSavedMessage);

        verify(controller,times(1))
                .addCustomer("Anna", "Sten", "mail@gmail.com","pass",
                        "Gatan 2", 11111L,"Stockholm", "15");

    }

    @Test
    void updateCustomer() {
        CustomerController controller = mock(CustomerController.class);
        CustomerRepository customerRepository = mock(CustomerRepository.class);

        String isUpdatedMessage = controller
                .updateCustomer("15", "Anna", "Sten", "mail@gmail.com", "Gatan 2",
                11111L,"Stockholm");

        when(controller
                .updateCustomer("15", "Anna", "Sten", "mail@gmail.com", "Gatan 2",
                11111L,"Stockholm")).thenReturn(isUpdatedMessage);

        verify(controller,times(1))
                .updateCustomer("15","Anna", "Sten", "mail@gmail.com","Gatan 2",
                        11111L,"Stockholm");
    }

    @Test
    void deleteCustomer() {
        final CustomerController controller =  mock(CustomerController.class);
        CustomerRepository customerRepository = mock(CustomerRepository.class);

        String isDeletedMessage = controller.deleteCustomer(15);

        when(controller.deleteCustomer(15)).thenReturn(isDeletedMessage);

        verify(controller).deleteCustomer(15);

    }

    @Test
    void updateCustomerPassword() {
        final CustomerController controller = mock(CustomerController.class);
        CustomerRepository customerRepository = mock(CustomerRepository.class);

        String isUpdatedMessage = controller.updateCustomerPassword("15", "newPassword");

        when(controller.updateCustomerPassword("15", "newPassword")).thenReturn(isUpdatedMessage);

        assertEquals(controller.updateCustomerPassword("15", "newPassword"), isUpdatedMessage);

        verify(controller,times(2)).updateCustomerPassword(any(),any());
    }

    @Test
    void getCustomerById() {
        final CustomerController controller = mock(CustomerController.class);
        CustomerRepository customerRepository = mock(CustomerRepository.class);

        Optional<Customer> customerById = controller.getCustomerById(15L);

        when(controller.getCustomerById(15L)).thenReturn(customerById);

        assertEquals(controller.getCustomerById(15L), customerById);

        verify(controller,times(2)).getCustomerById(any());

    }

}