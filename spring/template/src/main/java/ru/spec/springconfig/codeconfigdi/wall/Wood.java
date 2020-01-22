package template.src.main.java.ru.spec.springconfig.codeconfigdi.wall;

import org.springframework.stereotype.Component;

public class Wood implements Material {

    public void cover() {
        System.out.println("Put brick..");
    }
}
