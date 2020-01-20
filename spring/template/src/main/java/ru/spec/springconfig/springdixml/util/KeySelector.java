package template.src.main.java.ru.spec.springconfig.springdixml.util;

import ru.spec.springconfig.springdixml.door.Door;
import ru.spec.springconfig.springdixml.door.MetalDoor;

public class KeySelector {

    public String getKey(Door door) {
        if(door.getClass().equals(MetalDoor.class)) {
            return "a";
        } else {
            return "b";
        }
    }
}
