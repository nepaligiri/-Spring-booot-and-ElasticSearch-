package com.elastic.demo.customer;

import java.util.List;



public interface CustomerDAO  {
	
	 List<Customer> getAllCustomer();
	 
 //   Customer getCustomerById(int Id);
    
	   Customer addNewCustomer(Customer custoemer);
//	   
//	    Object getAllCustomerSettings(int  Id);
//	    
//	    String getCustoermSetting(int Id, String name);
//	    
//	    String addCustomerSetting(int Id, String name, String description);

}
