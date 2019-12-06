package com.wwy.uaa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import javax.sql.DataSource;
import java.util.Arrays;

/**
 * @author wwy
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private AuthorizationServerTokenServices tokenServices;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AuthorizationCodeServices authorizationCodeServices;
    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;
    @Autowired
    private JdbcClientDetailsService jdbcClientDetailsService;
    /**
     * 用于配置客户端详情服务
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(jdbcClientDetailsService);
                /*使用menmory存储
                inMemory()
                //client_id，标识客户id
                .withClient("c1")
                //(需要值得信任的）客户端安全码，
                .secret(new BCryptPasswordEncoder().encode("123"))
                //资源列表
                .resourceIds("res1")
                //该client允许的授权类型，以下为oauth2.0协议支持了4中授权类型
                .authorizedGrantTypes("password","authorization_code","client_credentials","implicit")
                //允许的授权范围，空的话拥有全部范围
                .scopes("all")
                //跳转到授权页面？
//                .autoApprove(false)
                //验证回调地址
                .redirectUris("http://www.baidu.com");*/
    }

    /**
     * 配置令牌（token)的访问端点(即url)和令牌服务
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        super.configure(endpoints);
        endpoints
                //密码模式需要,认证管理器
                .authenticationManager(authenticationManager)
                //授权码模式需要，授权码服务
                .authorizationCodeServices(authorizationCodeServices)
                //令牌管理服务
                .tokenServices(tokenServices)
                //只允许post提交访问
                .allowedTokenEndpointRequestMethods(HttpMethod.POST);
    }


    /**
     * 配置令牌端点的安全约束，功能跟HttpSecurity相同
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                // /token_key公开
                .tokenKeyAccess("permitAll()")
                // /check_token公开
                .checkTokenAccess("permitAll()")
                //通过表单认证申请令牌
                .allowFormAuthenticationForClients();
    }

    @Bean
    public AuthorizationServerTokenServices tokenServices(ClientDetailsService clientDetailsService,
                                                          JwtTokenStore jwtTokenStore,
                                                          JwtAccessTokenConverter jwtAccessTokenConverter){
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setClientDetailsService(clientDetailsService);
        //支持刷新令牌
        tokenServices.setSupportRefreshToken(true);
        //令牌刷新策略
        tokenServices.setTokenStore(jwtTokenStore);
        //令牌增强
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        System.out.println("上帝但是"+jwtAccessTokenConverter);
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(jwtAccessTokenConverter));
        tokenServices.setTokenEnhancer(tokenEnhancerChain);
        //令牌默认有效期为2h
        tokenServices.setAccessTokenValiditySeconds(7200);
        //刷新令牌默认有效期3d
        tokenServices.setRefreshTokenValiditySeconds(259200);
        return tokenServices;
    }
    @Bean
    public AuthorizationCodeServices authorizationCodeServices(DataSource dataSource){
        //设置授权码存取模式，采用内存
//        return new InMemoryAuthorizationCodeServices();
        return new JdbcAuthorizationCodeServices(dataSource);
    }
    @Bean
    public JdbcClientDetailsService jdbcClientDetailsService(DataSource dataSource, PasswordEncoder passwordEncoder){
        JdbcClientDetailsService clientDetailsService = new JdbcClientDetailsService(dataSource);
        clientDetailsService.setPasswordEncoder(passwordEncoder);
        return clientDetailsService;
    }

}
