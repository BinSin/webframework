package kr.ac.hansung.spring.aop;

import lombok.Setter;

@Setter
public class Cat implements AnimalType {

	private String myName;
	
	public void sound() {
		System.out.println("Dog name = " + myName + ":" + "Meow");
	}

}
