package template.src.test.java.main.java.ru.spec.springconfig.springdixml;

import java.util.Collection;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.spec.springconfig.springdixml.door.Door;
import ru.spec.springconfig.springdixml.wall.Material;
import ru.spec.springconfig.springdixml.window.Window;

@Component
public class House {

    private Window window;

    @Value("2")//for prop
    private int height;

    @Autowired //Inject   javax.inject
    @Qualifier("woodBean") //Named()
    private Material wall;
    //    private Collection<Door> doors;

    private Map<String, Door> doors;

    public House() {
    }

    public House(Window window) {
        this.window = window;
        this.height = height;
    }
    @Autowired
    public Map<String, Door> getDoors() {
        return doors;
    }

    public void setDoors(Map<String, Door> doors) {
        this.doors = doors;
    }


    public Material getWall() {
        return wall;
    }

    public void setWall(Material wall) {
        this.wall = wall;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Window getWindow() {
        return window;
    }

    public void setWindow(Window window) {
        this.window = window;
    }

    public void view() {
        window.open();
    }

    public void buildWall() {
        for (int i = 0; i < getHeight(); i++) {
            System.out.println("Flooe N " + i);
            getWall().cover();
        }
    }

    public void installDoors() {
//        for (Door door : doors) {
//            door.install();
//        }
        for (Map.Entry<String, Door> e : doors.entrySet()) {
            System.out.println("Key : " + e.getKey());
            e.getValue().install();
        }
    }
}
