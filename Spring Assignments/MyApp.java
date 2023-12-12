package mypack;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext appcontext=new ClassPathXmlApplicationContext("injection.xml");
		Soldier s=(Soldier) appcontext.getBean("Soldier1");
		s.perform();

	}

}
