package practise_springboot_store.src.main.java.ru.javagain.springstore.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends
    WebSecurityConfigurerAdapter { // class for configuring application security


  @Override
  protected void configure(HttpSecurity http) throws Exception {

    // temporarily disable security so that it does not require a login and password on the pages
    http.authorizeRequests()
        .antMatchers("/**").permitAll()

        .and()

        .csrf().disable();


  }
}