package template.src.main.java.ru.spec.springconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);
//        context.register(AppContext.class);
//        PersonBean iam = context.getBean("iam", PersonBean.class);
        UserBean iam = context.getBean( UserBean.class);
        System.out.println(iam.getAge() + " " + iam.getName());
        context.close();

    }
}
