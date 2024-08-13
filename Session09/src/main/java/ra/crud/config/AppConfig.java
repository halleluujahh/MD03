package ra.crud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"ra.crud.controller", "ra.crud.service.imp", "ra.crud.repository.imp"})
public class AppConfig {
    //Cấu hình cho View Resolve của SpringMVC
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        //set đường dẫn thư mục chứa các view cho resolver
        resolver.setPrefix("/views/");
        //set view là file .jsp
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
