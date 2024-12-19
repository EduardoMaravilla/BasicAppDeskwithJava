package org.eduardomaravill.data_analyze.configurations.webclient;

import io.netty.handler.codec.http.HttpContentCompressor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient webClient() {
        int maxInMemorySize = 100 * 1024 * 1024; // 100MB
        HttpClient httpClient = HttpClient.create()
                .responseTimeout(Duration.ofSeconds(30))
                .doOnConnected(conn -> conn.addHandlerLast(new HttpContentCompressor()));
        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(maxInMemorySize)).build();
    }
}
