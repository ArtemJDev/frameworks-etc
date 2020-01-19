package template.src.main.java.ru.spec.springconfig.springdixml.life;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class MainWindow implements InitializingBean, DisposableBean {

    private MainWindow() {
    }

    private static class MainWindowHolder {

        static MainWindow mainWindow = new MainWindow();
    }

    public static MainWindow getInstance() {
        return MainWindowHolder.mainWindow;
    }


    public void afterPropertiesSet() throws Exception {
        openConnection();
    }

    public void destroy() throws Exception {
        closeConnection();
    }

    public void show() {
        System.out.println("Show main Window");
    }

    public void openConnection() {
        System.out.println("Opening connection...");
    }

    public void closeConnection() {
        System.out.println("Closing connection...");
    }
}

