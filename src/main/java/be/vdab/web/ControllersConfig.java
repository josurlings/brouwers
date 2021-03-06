package be.vdab.web;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc 
@ComponentScan 
public class ControllersConfig extends WebMvcConfigurerAdapter
{ 
@Bean
InternalResourceViewResolver viewResolver()
{ 
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/JSP/"); 
		resolver.setSuffix(".jsp"); 
		return resolver;
}
	
@Override
public void addResourceHandlers(ResourceHandlerRegistry registry)
{ 
	registry.addResourceHandler("/images/**")
	.addResourceLocations("/images/"); 
	registry.addResourceHandler("/styles/**").addResourceLocations("/styles/");
	registry.addResourceHandler("/scripts/**").addResourceLocations("/scripts/");
}
	
@Bean
MessageSource messageSource()
{
ReloadableResourceBundleMessageSource messageSource
= new ReloadableResourceBundleMessageSource();
messageSource.setBasename("classpath:/teksten");
messageSource.setFallbackToSystemLocale(false);
return messageSource;
}

@Bean
LocalValidatorFactoryBean validatorFactory() 
{
LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
factory.setValidationMessageSource(messageSource());
return factory;
}

@Override
public Validator getValidator()
{
return new SpringValidatorAdapter(validatorFactory().getValidator());
}

}