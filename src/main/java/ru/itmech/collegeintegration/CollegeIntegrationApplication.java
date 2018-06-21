package ru.itmech.collegeintegration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.header.writers.StaticHeadersWriter;

@EnableWebSecurity
@SpringBootApplication
@ComponentScan
public class CollegeIntegrationApplication extends WebSecurityConfigurerAdapter implements CommandLineRunner {

    private final String userLogin;

    private final String userPassword;

    @Autowired
    public CollegeIntegrationApplication(@Value("${user.login}") String userLogin, @Value("${user.password}") String userPassword) {
        this.userLogin = userLogin;
        this.userPassword = userPassword;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser(User.withDefaultPasswordEncoder().username(this.userLogin).password(this.userPassword).roles("ADMIN"));
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.headers().addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Origin", "*"));

        http.authorizeRequests().antMatchers("/home").hasRole("ADMIN");

        http.httpBasic();
    }

    public static void main(String[] args) {
        SpringApplication.run(CollegeIntegrationApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
