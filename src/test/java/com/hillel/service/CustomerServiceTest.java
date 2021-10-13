//package com.hillel.service;
//
//import com.hillel.dao.CustomerDao;
//import com.hillel.dto.CustomerDto;
//import com.hillel.entity.Customer;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Collections;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class CustomerServiceTest {
//
//    @Mock
//    private CustomerDao customerDao;
//
//    private CustomerService customerService;
//
//    @BeforeEach
//    public void setUp() {
//        customerService = new CustomerService();
//    }
//
//    @Test
//    public void findAllCustomers() {
//        Customer customer = new Customer();
//        customer.setId(1L);
//        customer.setName("Name");
//
//        when(customerDao.findAllCustomers()).thenReturn(Collections.singletonList(customer));
//
//        List<CustomerDto> actualResult = customerService.findAllCustomers();
//
//        assertEquals(1, actualResult.size());
//        assertEquals("Name", actualResult.get(0).getName());
//        assertEquals(1, actualResult.get(0).getId());
//    }
//
//
//}