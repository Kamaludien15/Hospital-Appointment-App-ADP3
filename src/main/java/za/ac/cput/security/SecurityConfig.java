package za.ac.cput.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        auth.inMemoryAuthentication()
                .withUser("User")
                .password(encoder().encode("passwordUser"))
                .roles("USER");


        auth.inMemoryAuthentication()
                .withUser("Admin")
                .password(encoder().encode("passwordAdmin"))
                .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http.httpBasic()
                .and()
                .cors()
                .and()
                .authorizeHttpRequests()
                .antMatchers(HttpMethod.POST, "/hospital_appointment_management-db/**/save").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.POST, "/hospital_appointment_management-db/**/delete").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/hospital_appointment_management-db/**/read").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.GET, "/hospital_appointment_management-db/**/all").hasAnyRole("ADMIN", "USER")
                .and()
                .csrf().disable()
                .formLogin().disable();

    }



    @Bean
    public PasswordEncoder encoder(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }

}
