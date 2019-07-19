package ru.javabegin.training.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.javabegin.training.spring.impls.robot.ModelT1000;
import ru.javabegin.training.spring.interfaces.Robot;
import ru.javabegin.training.spring.interfaces.RobotConveyor;

public class Start {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
//		ModelT1000 t1000 = (ModelT1000) context.getBean("t1000");
//		System.out.println(t1000.getColor() + "  " + t1000.getHand());

    RobotConveyor t1000Conveyor = (RobotConveyor) context.getBean("t1000Conveyor");

    Robot terminator1 = t1000Conveyor.createRobot();
    Robot terminator2 = t1000Conveyor.createRobot();
    Robot terminator3 = t1000Conveyor.createRobot();

    System.out.println("terminator1 " + terminator1);
    System.out.println("terminator2 " + terminator2);
    System.out.println("terminator3 " + terminator3);
    System.out.println("");
    System.out.println("");
    terminator1.action();



	}
}
