package com.TrackApp.TrackApp.repository;

import com.TrackApp.TrackApp.domain.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by oana_ on 6/14/2017.
 */
public interface CustomerRepository extends CrudRepository<Customer,Integer> {
}
