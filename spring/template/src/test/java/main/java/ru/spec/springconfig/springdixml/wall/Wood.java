package template.src.test.java.main.java.ru.spec.springconfig.springdixml.wall;

import org.springframework.stereotype.Component;

@Component("woodBean")
public class Wood implements Material {

    public void cover() {
        System.out.println("Put brick..");
    }
}
