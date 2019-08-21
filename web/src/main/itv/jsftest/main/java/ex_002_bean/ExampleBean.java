package main.itv.jsftest.main.java.ex_002_bean;

import javax.inject.Named;

/**
 * Created by Asus on 20.05.2018.
 */

@Named
public class ExampleBean {

    private String text = "CDI Example";

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
