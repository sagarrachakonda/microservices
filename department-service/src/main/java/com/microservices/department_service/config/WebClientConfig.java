package com.microservices.department_service.config;

import com.microservices.department_service.employeeclient.EmployeeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebClientConfig {

    @Autowired
    private LoadBalancedExchangeFilterFunction filterFunction;

    @Bean
    public WebClient employeeWebClient(){
        return WebClient.builder()
                .baseUrl("http://employee-service")
                .filter(filterFunction)
                .build();
    }

    @Bean
    public EmployeeClient employeeClient(){

        // Set up the HttpServiceProxyFactory with the WebClient adapter
      /*  HttpServiceProxyFactory httpServiceProxyFactory =
                HttpServiceProxyFactory.builder(WebClientAdapter.forClient(employeeWebClient()))
                        .build();*/
        // Directly create HttpServiceProxyFactory with the WebClient instance
       // HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory.builder((HttpClientAdapter) employeeWebClient())
             //   .build();

        HttpServiceProxyFactory httpServiceProxyFactory =HttpServiceProxyFactory.builder(WebClientAdapter.forClient(employeeWebClient())).build();

                //create(employeeWebClient());

        // Create and return the EmployeeClient using the factory
        return httpServiceProxyFactory.createClient(EmployeeClient.class);
    }

}
