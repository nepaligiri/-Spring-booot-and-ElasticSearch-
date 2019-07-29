package com.elastic.demo.customer;




import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;




@Document(indexName ="customer", type="default")
public class Customer {
	@Id
	private int id;
	private String name;
	private int price;
	private  String description;
	

	private int product_no;
	

	 
	 public Customer() {
		 
	 }
	
	public Customer( int id,String name, int price, String description, int product_no,String productId ) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.product_no = product_no;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getProduct_no() {
		return product_no;
	}

	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}


	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", description=" + description + ", product_no="
				+ product_no + "]";
	}
	
	
	
	
	
	

}
