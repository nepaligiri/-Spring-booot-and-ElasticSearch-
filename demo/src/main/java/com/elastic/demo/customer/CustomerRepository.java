package com.elastic.demo.customer;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.elastic.demo.customer.Customer;

@Repository
public interface CustomerRepository extends ElasticsearchRepository<Customer,Integer> {

	


}
