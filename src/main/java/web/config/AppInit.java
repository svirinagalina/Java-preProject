package web.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    // Корневой контекст: JPA, транзакции, сервисы, DAO
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {
                AppConfig.class
        };
    }

    // Веб-контекст: контроллеры, view resolver, Thymeleaf
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {
                WebConfig.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
