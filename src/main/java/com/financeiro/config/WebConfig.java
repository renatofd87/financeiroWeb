package com.financeiro.config;

import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.repository.support.DomainClassConverter;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.financeiro.util.Constantes;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
		return (container ->
		container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, Constantes.URL_404),
							new ErrorPage(HttpStatus.FORBIDDEN, Constantes.URL_403)));
	}
	
	@Bean
	public DomainClassConverter<FormattingConversionService> domainClassConverter(
			FormattingConversionService conversionService) {
		return new DomainClassConverter<FormattingConversionService>(conversionService);
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController(Constantes.CARACTER_BARRA, Constantes.URL_DESPESA_NOVO);
	}
	
	@Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename(Constantes.DIRETORIO_LOCALES_MESSAGES);
        messageSource.setDefaultEncoding(Constantes.ENCODING);
        return messageSource;
    }
}
