package com.TrackApp.TrackApp.services.reposervices;

import com.TrackApp.TrackApp.domain.Customer;
import com.TrackApp.TrackApp.repository.CustomerRepository;
import com.TrackApp.TrackApp.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by oana_ on 6/14/2017.
 */

@Service
@Transactional(readOnly = true)
public class CustomerRepoServicesImp implements CustomerService {

    private CustomerRepository customerRepository;


    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @RolesAllowed("ADMIN")
    public List<?> listAll() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }

    @Override
    public Customer getById(Integer id)  {
        return customerRepository.findOne(id);
    }


    @Override
    @Transactional(readOnly = false)
    public Customer saveOrUpdate(Customer domainObject) {
        return customerRepository.save(domainObject);


    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id) {
        customerRepository.delete(id);
    }

    @Override
    public List<Customer> orderbyLastname() {

        return null;
    }
}
