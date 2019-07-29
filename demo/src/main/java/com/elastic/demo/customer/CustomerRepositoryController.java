package com.elastic.demo.customer;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.elastic.demo.customer.Customer;

@RestController
public class CustomerRepositoryController {

	@Autowired
	private CustomerRepository cusElasRepo;
	
	@PostMapping ("/customer/add")
	public Customer addCustomer(@RequestBody Customer customer) {
		
	
		
		return cusElasRepo.save(customer);
	}
		
		@GetMapping ("/customer/all")
		public List<Customer>getCustomer(){
			Iterator<Customer>iterator = cusElasRepo.findAll().iterator();
			List<Customer>cust = new ArrayList<Customer>();
		while (iterator.hasNext()) {
				cust.add(iterator.next());
			}
			return cust;
			
		}
	}
	

