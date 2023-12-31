package tregulov.spring.security.components.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        UserBuilder userBuilder = User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser(userBuilder.username("Alex").password("AlexPwd").roles("EMPLOYEE"))
                .withUser(userBuilder.username("Dmitry").password("DmitryPwd").roles("HR"))
                .withUser(userBuilder.username("Andrew").password("AndrewPwd").roles("MANAGER", "HR"));
    }

   @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/")
                .hasAnyRole("EMPLOYEE", "MANAGER", "HR")

                .antMatchers("/api/hr_info/**").hasRole("HR")
                .antMatchers("/api/managers_info/**").hasRole("MANAGER")
                .anyRequest().authenticated()
                .and().formLogin()
                .and().logout()
                .permitAll();
    }
}
