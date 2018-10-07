package com.item.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebMvc
@EnableWebSocket
public class WebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer {
	
    public static final String DEFAULT_WEBSOCKET_KEY = "wsKey";

    private static final Logger logger = LoggerFactory.getLogger(WebSocketConfig.class);
    
    @Bean
    public TextMessageHandler textMessageHandler() {
        return new TextMessageHandler();
    }
    
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(textMessageHandler(), "/wsServer").addInterceptors(new HandshakeInterceptor());
        registry.addHandler(textMessageHandler(), "/wsServer/socketjs").addInterceptors(new HandshakeInterceptor()).withSockJS();
    }
}
