package template.src.main.java.ru.spec.springconfig.codeconfigdi;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext
            (BuilderConfig.class);
        House houseBean = context.getBean(House.class);
        houseBean.buildWall();
        houseBean.view();
    }
}
