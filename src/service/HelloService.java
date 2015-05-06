package service;

import model.User;

public class HelloService {

	public String sayHello(String name){
		return "Hello,my name is "+name+"!";
	}
	public User getUserById(String userId){
		User us=new User();
		return us;
	}
	public void addUser(User user){
		System.out.println("addUser--------------");
	}
}
