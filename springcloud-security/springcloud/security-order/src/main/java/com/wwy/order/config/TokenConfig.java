package com.wwy.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @author wwy
 */
@Configuration
public class TokenConfig {
    private static final String SIGNING_KEY="uaa123";
    @Bean
    public TokenStore tokenStore(JwtAccessTokenConverter accessTokenConverter){
        //JWT令牌
        return new JwtTokenStore(accessTokenConverter);
    }
    @Bean
    public JwtAccessTokenConverter accessTokenConverter(){
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(SIGNING_KEY);
        return converter;
    }
}
