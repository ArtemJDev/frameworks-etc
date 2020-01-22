package template.src.test.java.main.java.ru.spec.springconfig.springdixml.door;

import org.springframework.stereotype.Component;

@Component
public class MetalDoor implements Door {

    public void install() {
        System.out.println("Metal Door installing");
    }
}
