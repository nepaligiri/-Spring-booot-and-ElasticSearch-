package com.elastic.demo.customer;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.elastic.demo.customer.CustomerDAO;

import com.elastic.demo.customer.Customer;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
//	private Gson gson;
//	private RestClient restClint;
//	
//	@PostConstruct
//	public void init() {
//		gson = new Gson();
//		restClint = RestClient.builder(
//				new HttpHost ("localhost",9200, "http")
//				).build();
//	}
//	
	
	
	@Autowired
	private CustomerDAO customerDAO;
	
	 @RequestMapping("/all")
	    public List<Customer> getAllCustomer() {
	        return customerDAO.getAllCustomer();
	 }
//	 @RequestMapping("/id/Id}")
//	    public Customer getUser(@PathVariable int Id) {
//	       Customer user = customerDAO.getCustomerById(Id);
//	        return user;
//	    }

	        
	        @RequestMapping(value = "/new", method = RequestMethod.POST)
	        public Customer addNewCustomer(@RequestBody Customer customer) {
	            customerDAO.addNewCustomer(customer);
	            return customer;
}
}