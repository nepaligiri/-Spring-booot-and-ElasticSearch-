package com.elastic.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;


@Configuration
@EnableElasticsearchRepositories(basePackages = "com.elastic.demo.customer")
@ComponentScan(basePackages = {"com.elastic.demo.customer"})
public class ElasticsearchConfiguration{
@Value("${elasticsearch.home:C:\\Users\\igiri\\Downloads\\elasticsearch-6.4.3\\elasticsearch-6.4.3}")
private String elasticsearchHome;

@Value("${elasticsearch.cluster.name:application}")
private String clusterName;

@Bean
public Client client() {
    try {
        final Settings elasticsearchSettings = Settings.builder()
                .put("client.transport.sniff", true)
                .put("path.home", elasticsearchHome)
                .put("cluster.name", clusterName).build();
    
		TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300));

        return client;
    } catch (UnknownHostException ex) {
       
    return null;
}
}

@Bean
public ElasticsearchOperations elasticsearchTemplate() {
    return new ElasticsearchTemplate(client());
}
}