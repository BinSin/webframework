package kr.ac.hansung.spring.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

// @RequiredArgsConstructor
public class PetOwner {

	@Autowired
	@Qualifier(value="qf_dog")
	private AnimalType animal;
	
	public void play() {
		animal.sound();
	}
}
