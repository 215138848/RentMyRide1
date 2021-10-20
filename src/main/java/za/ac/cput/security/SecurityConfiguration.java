
package za.ac.cput.security;
        import org.springframework.context.annotation.Bean;
        import org.springframework.http.HttpMethod;
        import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
        import org.springframework.security.config.annotation.web.builders.HttpSecurity;
        import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
        import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
        import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
        import org.springframework.security.crypto.password.PasswordEncoder;

public class SecurityConfiguration  extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.inMemoryAuthentication()
                .withUser("Asiphiwe")
                .password("Han29087")
                .roles("ADMIN")
                .and()
                .withUser("Tyronne")
                .password("29087@Han")
                .roles("USER");
    }
    @Bean
    protected void configure(HttpSecurity httpSecurity) throws Exception
    {
        httpSecurity.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"**/create").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "**/getAll").hasRole("USER")
                .and()
                .csrf().disable()
                .formLogin().disable();

    }

    public PasswordEncoder encoder()
    {
        return new BCryptPasswordEncoder();
    }
}
