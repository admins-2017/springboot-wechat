package com.kang.utils.Quartz.QuartzConfig;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class SpringUtil implements BeanFactoryPostProcessor {

    private static ConfigurableListableBeanFactory beanFactory;
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        SpringUtil.beanFactory = beanFactory;
    }

    public static Object getBean(String name) {
        return beanFactory.getBean(name);
    }
    public static <T> T getBean(Class<T> clazz){
        return beanFactory.getBean(clazz);
    }
}