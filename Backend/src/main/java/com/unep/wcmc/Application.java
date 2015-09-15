package com.unep.wcmc;

import com.unep.wcmc.model.BaseEntity;
import org.javers.core.Javers;
import org.javers.core.JaversBuilder;
import org.javers.core.graph.ObjectAccessHook;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
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

    @Bean
    public Javers javers() {
        return JaversBuilder.javers()
                .withObjectAccessHook(new ObjectAccessHook() {
                    @Override
                    public <T> T access(T entity) {
                        if (entity instanceof BaseEntity) {
                            BaseEntity base = (BaseEntity) entity;
                            if (base.getId() == null)
                                base.setId(-1l);
                        }
                        return entity;
                    }})
                .build();
    }

   /* @Bean
    public MultipartResolver multipartResolver() {
        org.springframework.web.multipart.commons.CommonsMultipartResolver multipartResolver = new org.springframework.web.multipart.commons.CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(1000000);
        return multipartResolver;
    }*/
}
