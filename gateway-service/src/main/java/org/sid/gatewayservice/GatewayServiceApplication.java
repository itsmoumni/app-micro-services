package org.sid.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }



    ////////////////////////
    // Static Configuration:
    ////////////////////////

    // Using Eureka Discovery Client to Contact the Micro-services with their names:

    /*@Bean
    RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder.routes()
                .route(r-> r.path("/customers/**").uri("lb://CUSTOMER-SERVICE"))
                .route(r-> r.path("/products/**").uri("lb://PRODUCT-SERVICE")).build();
    }*/


    // Using Explicit Addresses:port-number to Contact the Micro-services:

    /*@Bean
    RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder.routes()
        .route(r-> r.path("/customers/**").uri("http://localhost:8081"))
                .route(r-> r.path("/products/**").uri("http://localhost:8082")).build();
    }*/



    /////////////////////////
    // Dynamic Configuration:
    /////////////////////////

    // Contacting the Micro-services name based on URL

    @Bean
    DiscoveryClientRouteDefinitionLocator definitionLocator(ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties properties){
        return new DiscoveryClientRouteDefinitionLocator(rdc,properties);
    }

}
