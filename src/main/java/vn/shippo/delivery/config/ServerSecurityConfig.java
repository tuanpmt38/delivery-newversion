package vn.shippo.delivery.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import vn.shippo.delivery.filter.DemoAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class ServerSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN");
        http
                .addFilterBefore(new DemoAuthenticationFilter(), DemoAuthenticationFilter.class);
    }

    @Override
    protected UserDetailsService userDetailsService() {
        return super.userDetailsService();
    }
}

