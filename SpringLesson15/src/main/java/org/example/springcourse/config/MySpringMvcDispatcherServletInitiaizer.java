package org.example.springcourse.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMvcDispatcherServletInitiaizer extends AbstractAnnotationConfigDispatcherServletInitializer {

    // данный файл заменяет web.xml --- это Java конфигурация.
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null; // этот метод не используем, поэтому возвращаем null
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringConfig.class}; // возвращаем класс SpringConfig: наш "web.xml" знает, где находится
        // "applicationContext.xml"
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};  // это эквивалентно тому, что все http запросы от пользователя посылаем на
        // dispatcher servlet
    }
}
