package at.notify;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.LocaleResolver;  

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class} ) 
public class TelegramApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(TelegramApplication.class, args);
		System.out.println("main start.. ");
	}
	  
    @Bean
	public LocaleResolver localeResolver() {
	    SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
	    sessionLocaleResolver.setDefaultLocale(Locale.FRANCE);
	    return sessionLocaleResolver;
	} 

}
