package com.unep.wcmc;

import com.unep.wcmc.config.SolrContext;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@Import(SolrContext.class )
public class Application {

    private static Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * By defining the {@link KieContainer} as a bean here, we ensure that
     * Drools will hunt out the kmodule.xml and rules on application startup.
     * Those can be found in <code>src/main/resources</code>.
     *
     * @return The {@link KieContainer}.
     */
    @Bean
    public KieContainer kieContainer() {
        return KieServices.Factory.get().getKieClasspathContainer();
    }
}
