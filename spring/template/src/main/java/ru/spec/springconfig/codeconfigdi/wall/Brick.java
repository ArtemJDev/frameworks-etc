package template.src.main.java.ru.spec.springconfig.codeconfigdi.wall;

public class Brick implements Material {

    public Brick() {
        System.out.println("-----------");
    }

    public void cover() {
        System.out.println("Put brick");
    }
}
