package co.yellowbricks.bggclient.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import co.yellowbricks.bggclient.fetch.CollectionQualifier;
import co.yellowbricks.bggclient.fetch.FetchQualifier;
import co.yellowbricks.bggclient.fetch.domain.FetchItemOutput;
import co.yellowbricks.bggclient.fetch.domain.UserCollection;
import co.yellowbricks.bggclient.search.SearchQualifier;
import co.yellowbricks.bggclient.search.domain.SearchOutput;

@Configuration
@ComponentScan(basePackages = "co.yellowbricks.bggclient")
public class SpringContext {

    @Bean
    public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();

        ppc.setLocation(new ClassPathResource("/xmlapi.properties"));
        return ppc;
    }
    
    @Bean @SearchQualifier
    public Jaxb2Marshaller jaxb2SearchMarshaller() {
    	Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
    	
    	jaxb2Marshaller.setClassesToBeBound(SearchOutput.class);
    	return jaxb2Marshaller;
    }
    
    @Bean @FetchQualifier
    public Jaxb2Marshaller jaxb2FetchMarshaller() {
    	Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
    	
    	jaxb2Marshaller.setClassesToBeBound(FetchItemOutput.class);
    	return jaxb2Marshaller;
    }
    
    @Bean @CollectionQualifier
    public Jaxb2Marshaller jaxb2CollectionMarshaller() {
    	Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
    	
    	jaxb2Marshaller.setClassesToBeBound(UserCollection.class);
    	return jaxb2Marshaller;
    }
}
