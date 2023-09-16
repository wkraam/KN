package com.KN.OrderManagementSystem.Service;

import com.KN.OrderManagementSystem.Exceptions.CustomerNotFoundException;
import com.KN.OrderManagementSystem.Model.Customer;
import com.KN.OrderManagementSystem.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer addCustomer(Customer newCustomer){
        return customerRepository.save(newCustomer);
    }

    public Customer updateCustomer(Customer newCustomer) {
        return customerRepository.save(newCustomer);
    }

    public Customer findCustomerByIds(Long id) throws Throwable {
        return customerRepository.findCustomerById(id).orElseThrow(() -> new CustomerNotFoundException("Customer: "+id+" is not int the database"));
    }

    public List<Customer> findAllCustomers(){
        return customerRepository.findAll();
    }

    public void deleteCustomer(Customer delCustomer){
        customerRepository.delete(delCustomer);
    }

}
