package template.src.main.java.ru.spec.springconfig.springjavaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {

    @Bean
    public UserBean user() {
        return new UserBean("Mark", 22);
    }
}
