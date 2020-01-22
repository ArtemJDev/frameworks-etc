package template.src.test.java.main.java.ru.spec.springconfig;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.spec.springconfig.springdixml.House;
import ru.spec.springconfig.springdixml.life.MainWindow;

public class App {

    public static void main(String[] args) {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext");
        //        PersonBean iam = context.getBean("iam", PersonBean.class);

        //Java Config
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
//            AppContext.class);
//        context.register(AppContext.class);
//        UserBean iam = context.getBean( UserBean.class);
//        System.out.println(iam.getAge() + " " + iam.getName());

        //Xml Java Config
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext
            ("applicationContext");
//        Window window = context.getBean("windowBean", Window.class);
//        new House(window).view();//manual impl
        House houseBean = context.getBean("houseBean", House.class);
        houseBean.buildWall();
        houseBean.installDoors();
        houseBean.view();
        System.out.println(houseBean.getHeight());

        MainWindow window = context.getBean(MainWindow.class);
        window.show();
        context.close();

    }
}
