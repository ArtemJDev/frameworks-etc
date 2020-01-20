package template.src.main.java.ru.spec.springconfig.codeconfigdi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.spec.springconfig.codeconfigdi.wall.Brick;
import ru.spec.springconfig.codeconfigdi.window.Window;
import ru.spec.springconfig.codeconfigdi.window.WoodWindow;

@Configuration
public class BuilderConfig {
    @Bean
    public Window woodWindow() {
        return new WoodWindow();
    }
    @Bean("wall")
    @Scope("prototype")
    public Brick brickWall() {
        return new Brick();
    }
    @Bean
    public House house() {
        House house = new House(woodWindow());
        house.setHeight(2);
        return house;
    }
}
