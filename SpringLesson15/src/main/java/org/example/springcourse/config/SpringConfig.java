package org.example.springcourse.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import javax.sql.DataSource;

// конфигурационный Джава Класс
@Configuration
@ComponentScan("org.example.springcourse")
@EnableWebMvc   // равноценна аннотации:  <mvc:annotation-driven/> в  AnnotationContextMvc
public class SpringConfig implements WebMvcConfigurer {  // реализуется в случае, когда мы хотим под себя настроить Спринг Мвс
    // используем его, потому что хотим использовать шаблонизитор ТаймЛиф вместо стандартнго шаблонизатора

    // Конфигурация в данном файле полоностью эквивалентна конфигурации в файле applicationContextMvc.xml
    // (см. прошлый урок)

    private final ApplicationContext applicationContext;

    @Autowired
    public SpringConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/views/");  // папка, в которой будут лежать наши представления
        templateResolver.setSuffix(".html"); // расширение этих представлений
        return templateResolver;
    }

    @Bean  // конфигурация наших представлений
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }

    @Override  // в этом методе задаем шаблонизтор Таймлиф
    public void configureViewResolvers(ViewResolverRegistry registry) {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        registry.viewResolver(resolver);
    }
    @Bean
    public DataSource dataSource(){

        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mystore");
        dataSource.setUsername("root");
        dataSource.setPassword("6677");

        return dataSource;
    }


    @Bean
    public JdbcTemplate jdbcTemplate(){

        return new JdbcTemplate(dataSource());

    }



}
