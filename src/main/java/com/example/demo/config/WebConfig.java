//package com.example.demo.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Configurable;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//@Configurable
//@EnableWebSecurity
//// Modifying or overriding the default spring boot security.
//public class WebConfig extends WebSecurityConfigurerAdapter {
//
//	// This method is for overriding the default AuthenticationManagerBuilder.
//	// We can specify how the user details are kept in the application. It may
//	// be in a database, LDAP or in memory.
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	}
//
//	// this configuration allow the client app to access the this api 
//	// all the domain that consume this api must be included in the allowed o'rings 
//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//	    return new WebMvcConfigurerAdapter() {
//	        @Override
//	        public void addCorsMappings(CorsRegistry registry) {
//	            registry.addMapping("/**").allowedOrigins("http://localhost:4200");
//	          
//	        }
//	    };
//	}
//	// This method is for overriding some configuration of the WebSecurity
//	// If you want to ignore some request or request patterns then you can
//	// specify that inside this method
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		super.configure(web);
//	}
//
//	// This method is used for override HttpSecurity of the web Application.
//	// We can specify our authorization criteria inside this method.
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.cors().and()
//		// starts authorizing configurations
//		.authorizeRequests()
//		.antMatchers("/produit/all", "/produit/{id}").permitAll()
//		.antMatchers("/produit-commande/all","/produit-commande/{id}", "/produit-commande/delete/{id}","/produit-commande/save","/produit-commande/update","/produit-commande/user/{id}").permitAll()
//		.antMatchers("/panier/all","/panier/{id}","/produit-commande/delete/panier/{id}","/panier/save","/panier/update","/panier/user/{id}").permitAll()
//		
//		// ignoring the guest's urls "
//		.antMatchers("/quiz","/questions/{id}").permitAll()
//		// authenticate all remaining URLS
//		.anyRequest().fullyAuthenticated().and()
//      /* "/logout" will log the user out by invalidating the HTTP Session,
//       * cleaning up any {link rememberMe()} authentication that was configured, */
//		.logout()
//        .permitAll(true)
//		.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "POST"))
//        .and()
//		// enabling the basic authentication
//		.httpBasic().and()
//		// configuring the session on the server
//		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED).and()
//		// disabling the CSRF - Cross Site Request Forgery
//		.csrf().disable();
//	}
//
//}