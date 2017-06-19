package SpringBootSecurity.config;

import SpringBootSecurity.security.CustomUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * spring security配置
 * Created by Lee on 2017/6/19 0019.
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    @Bean
    UserDetailsService customUserService(){//注册CustomUserService的bean
        return new CustomUserService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService());//添加自定义的UserDetailsService
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()//所有请求需要认证（登录）后才能访问
                .and()
                .formLogin()//定制登录操作
                    .loginPage("/login")
                    .failureUrl("/login?error")
                    .permitAll()//可以任意访问
                .and()
                .logout()//定制注销操作
                    .permitAll();
    }
}
