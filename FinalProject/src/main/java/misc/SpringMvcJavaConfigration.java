package misc;

import java.util.Locale;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.context.support.ServletContextResource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.XmlViewResolver;
@Configuration
@ComponentScan(basePackages= {"controller"})
@EnableWebMvc
public class SpringMvcJavaConfigration implements WebMvcConfigurer {
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource RBMS =new ResourceBundleMessageSource();
		RBMS.setBasename("error.message");
		//多國語系錯誤訊息
		return RBMS;
	}
	@Autowired
	private ServletContext servletContext;
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		
		XmlViewResolver XVR = new XmlViewResolver();
		XVR.setLocation(new ServletContextResource(servletContext, "/WEB-INF/Spring-views.xml"));
		registry.viewResolver(XVR);
		
		InternalResourceViewResolver internalResourceViewResolver =new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF");
		internalResourceViewResolver.setSuffix(".jsp");
		registry.viewResolver(internalResourceViewResolver);
	}
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.FRANCE);
		return localeResolver;
	}
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	

}
