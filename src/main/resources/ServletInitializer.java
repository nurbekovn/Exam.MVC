package com; // Тот же пакет, что и у главного класса

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        // Здесь нужно указать ваш главный класс приложения
        return application.sources(ExamMvcApplication.class); // Если назвали главный класс иначе, измените здесь
    }
}