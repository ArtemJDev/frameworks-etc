package ru.training.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("all_context.xml");
		ModelT1000 model1 = (ModelT1000) context.getBean("model1");
		ModelT1000 model2 = (ModelT1000) context.getBean("model2");
//		ModelT1000 model2 = (ModelT1000) context.getBean("model2");
		// ModelT1000 model3 = (ModelT1000) context.getBean("model1");
		model1.action();
		System.out.println(model1);
		model2.action();
		System.out.println(model2);
//		model2.action();
		// System.out.println(model3);
	}
}
