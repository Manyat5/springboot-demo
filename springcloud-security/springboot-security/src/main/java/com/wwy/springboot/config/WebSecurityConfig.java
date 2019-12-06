package com.wwy.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 安全配置
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 配置用户信息服务(测试用）
     */
//    @Bean
//    @Override
//    public UserDetailsService userDetailsService() {
//        //内存
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        //设置允许访问的user
//        manager.createUser(User.withUsername("zs").password("123").authorities("admin").build());
//        return manager;
//    }
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
        http.
            sessionManagement().maximumSessions(1).expiredUrl("/login").and().
            sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED).

            and().
//            csrf().disable().//关闭csrf
            authorizeRequests().
            antMatchers("/r/r1").hasAuthority("p1").//需要权限访问
            antMatchers("/r/r2").hasAuthority("p2").
            antMatchers("/r/**").authenticated().//所有/r/**的请求必须认证通过，其他都不需要认证
            anyRequest().permitAll().   //写了这条语句后，后面的资源限制语句不再执行，所以要放在最后面
            and().formLogin().loginPage("/login")//允许表单登录
//            and().logout().logoutUrl("")
            ;
            //默认登录成功回跳原地址
    }
}
