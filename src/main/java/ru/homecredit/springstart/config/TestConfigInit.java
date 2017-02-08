package ru.homecredit.springstart.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author dima
 */
@Configuration
public class TestConfigInit implements InitializingBean {

    @Bean(initMethod = "isEmpty")
    public ConcurrentHashMap<Long, String> repository() {
        System.out.println(" ----- inject bean");
        return new ConcurrentHashMap<Long, String>() {
            @Override
            public boolean isEmpty() {
                System.out.println(" +++++++ INIT method");
                return super.isEmpty();
            }
        };
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(" ********* TestConfigInit.afterPropertiesSet");
    }

    @PostConstruct
    public void postConstructInit() throws Exception {
        System.out.println(" ********* PostConstruct");
    }

    public void init() throws Exception {
        System.out.println(" ********* init");
    }
}
