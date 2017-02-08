package ru.homecredit.springstart.config;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

/**
 * @author dima
 */
@Component
public class SpringContextStartEventListenerTest implements ApplicationListener<ContextStartedEvent> {

    @Override
    public void onApplicationEvent(ContextStartedEvent contextStartedEvent) {
        System.out.println(" ********* ContextStartedEvent");
    }
}
