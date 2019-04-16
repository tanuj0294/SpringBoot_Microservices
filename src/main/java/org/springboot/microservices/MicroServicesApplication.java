package org.springboot.microservices;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class MicroServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServicesApplication.class, args);
	}
	
	@Bean
	public LocaleResolver getLocaleResolver() {
		SessionLocaleResolver l = new SessionLocaleResolver();
		l.setDefaultLocale(Locale.US);
		return l;
	}
	
	@Bean
	public MessageSource configureBundleMessageSource() {
		ReloadableResourceBundleMessageSource  rm = new ReloadableResourceBundleMessageSource ();
		rm.setBasename("classpath:messages");
		return rm;
	}
}