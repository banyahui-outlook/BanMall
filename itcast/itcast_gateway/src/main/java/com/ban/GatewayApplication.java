package com.ban;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.util.MultiValueMap;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.util.pattern.PathPatternParser;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

@Slf4j
@SpringBootApplication
@RefreshScope
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public GlobalFilter customFilter() {
        return new CustomGlobalFilter();
    }

    @Value("${app.name}")
    private String appName;

    // https://docs.spring.io/spring-cloud-gateway/docs/current/reference/html/#global-filters
    public class CustomGlobalFilter implements GlobalFilter, Ordered {
        @Override
        public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
            log.info("custom global filter");
            ServerHttpRequest request = exchange.getRequest();
            MultiValueMap<String, String> params = request.getQueryParams();
            String token = params.getFirst("token");
            if (token != null && token.equals("abc")) return chain.filter(exchange);
            return denyAccess(exchange);
        }

        private Mono<Void> denyAccess(ServerWebExchange exchange) {
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.OK);
            response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
            byte[] bytes = (appName + ",faild visit").getBytes(StandardCharsets.UTF_8);
            DataBuffer buffer = response.bufferFactory().wrap(bytes);
            return response.writeWith(Mono.just(buffer));
        }

        @Override
        public int getOrder() {
            return -1;
        }
    }

    // https://blog.csdn.net/qq_35673617/article/details/113686609
    // @Bean
    public CorsWebFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedMethod("*");
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(new PathPatternParser());
        source.registerCorsConfiguration("/**", config);
        return new CorsWebFilter(source);
    }
}
