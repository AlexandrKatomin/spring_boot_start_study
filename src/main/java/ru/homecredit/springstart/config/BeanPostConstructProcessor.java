package ru.homecredit.springstart.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import ru.homecredit.springstart.controller.HelloWorldController;

/**
 * @author dima
 */
@Component
public class BeanPostConstructProcessor implements BeanPostProcessor {
    String nameClass;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof TestConfigInit || bean instanceof HelloWorldController) {
            nameClass = bean.getClass().getSimpleName();
            System.out.println(" ********* " + "postProcessBeforeInitialization     " + beanName);
            System.out.println(" ********* " + "postProcessBeforeInitialization     " + nameClass);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof TestConfigInit || bean instanceof HelloWorldController) {
            System.out.println(" ********* postProcessAfterInitialization " + nameClass);
        }
        return bean;
    }
}
