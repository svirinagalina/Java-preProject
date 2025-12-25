package web.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

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
    @Override
    public void onStartup(ServletContext aServletContext) throws ServletException {
        super.onStartup(aServletContext);

        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        aServletContext.addFilter("encodingFilter", characterEncodingFilter)
                .addMappingForUrlPatterns(null, true, "/*");
    }
}
