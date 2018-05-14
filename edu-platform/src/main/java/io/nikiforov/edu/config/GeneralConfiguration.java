package io.nikiforov.edu.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;

@Configuration
public class GeneralConfiguration {
    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() throws FileNotFoundException {
        final String absoluteKeystoreFile = ResourceUtils.getFile("keystore/keystore.p12").getAbsolutePath();
        final TomcatConnectorCustomizer customizer = new MyTomcatConnectionCustomizer(
                absoluteKeystoreFile, "nH2e8PWkLQ0mmTYpdEKS", "PKCS12", "keyalias"
        );
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                if (container instanceof TomcatEmbeddedServletContainerFactory) {
                    TomcatEmbeddedServletContainerFactory containerFactory = (TomcatEmbeddedServletContainerFactory) container;
                    containerFactory.addConnectorCustomizers(customizer);
                }

            }
        };
    }
}
