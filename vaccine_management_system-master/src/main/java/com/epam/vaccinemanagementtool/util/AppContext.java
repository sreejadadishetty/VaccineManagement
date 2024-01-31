package com.epam.vaccinemanagementtool.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class AppContext implements ApplicationContextAware {
    private static ApplicationContext context = null;

    public static ApplicationContext getApplicationContext() {
        return AppContext.context;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static void closeContext() {
        ((ConfigurableApplicationContext) context).close();
    }
}

