package co.yellowbricks.bggclient.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@ComponentScan(basePackages = "co.yellowbricks.bggclient")
public class SpringContext {

    @Bean
    public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();

        ppc.setLocation(new ClassPathResource("/xmlapi.properties")); //$NON-NLS-1$
        return ppc;
    }
}
