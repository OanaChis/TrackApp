package com.TrackApp.TrackApp.services;

import com.TrackApp.TrackApp.domain.Customer;

import java.util.List;

/**
 * Created by oana_ on 6/14/2017.
 */
public interface CustomerService extends CrudService<Customer>{
    List<Customer> orderbyLastname();
}
