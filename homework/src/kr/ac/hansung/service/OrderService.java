package kr.ac.hansung.service;

public class OrderService {

	// Card Number가 같은 값을 같는지 체크
	public boolean checkCardNumber(String num1, String num2) {
		if (num1 == "" || num2 == "")
			return false;

		if (num1.equals(num2)) {
			return true;
		} else
			return false;
	}
}
