package com.elastic.demo.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Repository;
import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;








@Repository
public class CustomerDAOImpl implements CustomerDAO {
	// private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	
	    @Value("${elasticsearch.index.name}")
	    private String indexName;
	    
	    @Value("${elasticsearch.user.type}")
	    private String userTypeName;
	    
	    @Autowired
	    private ElasticsearchTemplate esTemplate;
	   
	    
	    @Override
	    public List<Customer> getAllCustomer() {
	        SearchQuery getAllQuery = new NativeSearchQueryBuilder()
	                .withQuery(matchAllQuery()).build();
	        return esTemplate.queryForList(getAllQuery, Customer.class);
	    }
	    
	    @Override
	    public Customer addNewCustomer(Customer customer) {

	        IndexQuery userQuery = new IndexQuery();
	        userQuery.setIndexName(indexName);
	        userQuery.setType(userTypeName);
	        userQuery.setObject(customer);

	       // LOG.info("User indexed: {}", esTemplate.index(userQuery));
	        esTemplate.refresh(indexName);

	        return customer;
	    }

}
