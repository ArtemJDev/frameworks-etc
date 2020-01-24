package template_data.src.main.java.ru.spec.springconfig.codeconfigdi;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import ru.spec.springconfig.codeconfigdi.door.Door;
import ru.spec.springconfig.codeconfigdi.wall.Brick;
import ru.spec.springconfig.codeconfigdi.wall.Material;
import ru.spec.springconfig.codeconfigdi.window.Window;

public class House {

    private Window window;
    private int height;
    @Autowired
    private Brick wall;
    //    private Collection<Door> doors;

    private Map<String, Door> doors;

    public House() {
    }

    public House(Window window) {
        this.window = window;
    }

    public Map<String, Door> getDoors() {
        return doors;
    }

    public void setDoors(Map<String, Door> doors) {
        this.doors = doors;
    }


    public Material getWall() {
        return wall;
    }

    public void setWall(Brick wall) {
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
            System.out.print("Flooe N " + i + " ");
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
