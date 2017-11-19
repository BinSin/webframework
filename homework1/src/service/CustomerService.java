package service;

import java.util.HashMap;
import java.util.Map;

import model.Customer;

public class CustomerService {

	private Map<String, Customer> customerMap;
	
	public CustomerService() {
		customerMap = new HashMap<String, Customer>();
		
		addCustomer(new Customer("hansung1", "1", "빈용민"));
		addCustomer(new Customer("hansung2", "12", "이정현"));
		addCustomer(new Customer("hansung3", "123", "박지호"));
		addCustomer(new Customer("hansung4", "1234", "조용장"));
	}
	
	private void addCustomer(Customer customer) {	
		customerMap.put(customer.getId(), customer);
		customerMap.put(customer.getPwd(), customer);
	}
	// id 찾음
	public Customer findCustomerId(String id) {
		
		if(id != null) {
			return (customerMap.get(id));
		}
		else
			return null;
	}
	// password 찾음
	public Customer findCustomerPwd(String pwd) {
		
		if(pwd != null) {
			return (customerMap.get(pwd));
		}
		else
			return null;
	}
}
