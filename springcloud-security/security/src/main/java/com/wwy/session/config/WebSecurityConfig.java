package com.wwy.session.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * 安全配置
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 配置用户信息服务
     */
    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        //内存
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        //设置允许访问的user
        manager.createUser(User.withUsername("zs").password("123").authorities("admin").build());
        return manager;
    }
    /**
     *密码编码器
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    /**
     * 配置安全拦截机制
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().
                antMatchers("/r/r1").hasAuthority("p1").//需要权限访问
                antMatchers("/r/**").authenticated().//所有/r/**的请求必须认证通过，其他都不需要认证
                anyRequest().permitAll().
                and().formLogin().successForwardUrl("/login-success");//允许表单登录
    }
}
