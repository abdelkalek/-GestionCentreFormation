package pfa.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers("/login/**","/register/**").permitAll();
        http.authorizeRequests().antMatchers("/appUsers/**","/appRoles/**").hasAuthority("ADMIN");
        http.authorizeRequests().antMatchers("/formateur/**").permitAll();
        http.authorizeRequests().antMatchers("/candidat/**").permitAll();
        http.authorizeRequests().antMatchers("/formation/**").permitAll();
        http.authorizeRequests().antMatchers("/Categorie/**").permitAll();
        http.authorizeRequests().antMatchers("/admin/**").permitAll();
        http.authorizeRequests().antMatchers("/reclamation/**").permitAll();
        http.authorizeRequests().antMatchers("/commentaire/**").permitAll();
      http.authorizeRequests().antMatchers("/promotion/**").permitAll();

        http.authorizeRequests().antMatchers("/Avis/**").permitAll();
        http.authorizeRequests().antMatchers("/upload/**").permitAll();

        http.authorizeRequests().antMatchers("/fichedepresence/**").permitAll();
        http.authorizeRequests().antMatchers("/emploiT/**").permitAll();
        http.authorizeRequests().antMatchers("/session/**").permitAll();
        http.authorizeRequests().antMatchers("/salle/**").permitAll();
        http.authorizeRequests().antMatchers("/support/**").permitAll();
        http.authorizeRequests().antMatchers("/Materil/**").permitAll();
        http.authorizeRequests().antMatchers("/Besoin/**").permitAll();


        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
        http.addFilterBefore(new JWTAuthorizationFiler(), UsernamePasswordAuthenticationFilter.class);
    }
}
