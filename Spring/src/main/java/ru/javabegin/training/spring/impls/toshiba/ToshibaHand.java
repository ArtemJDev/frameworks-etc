package ru.javabegin.training.spring.impls.toshiba;

import ru.javabegin.training.spring.interfaces.Hand;

public class ToshibaHand implements Hand{

	private String color;
	
	public void catchSomething(){
		System.out.println("Catched from Toshiba!");
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
