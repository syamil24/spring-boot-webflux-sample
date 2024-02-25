package com.madlim.reactive.reactiveprogramming.service;

import com.madlim.reactive.reactiveprogramming.dao.CustomerDao;
import com.madlim.reactive.reactiveprogramming.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public List<Customer> loadAllCustomers(){
       long startValue = System.currentTimeMillis();
       List<Customer> customers = customerDao.getCustomers();
       long end = System.currentTimeMillis();
       System.out.println("Total Execution Time:: " + (end - startValue));
       return customers;

    }

    public Flux<Customer> loadAllCustomersStream(){
        long startValue = System.currentTimeMillis();
        Flux<Customer> customers = customerDao.loadAllCustomersStream();
        long end = System.currentTimeMillis();
        System.out.println("Total Execution Time:: " + (end - startValue));
        return customers;

    }
}
