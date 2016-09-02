package cn.wzd.po.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.wzd.po.Person;

public class TestPerson {
	
	private ClassPathXmlApplicationContext ctx;
	
	@Before
	public void setUp(){
		String configLocation = "classpath:ApplicationContext.xml";
		this.ctx = new ClassPathXmlApplicationContext(configLocation);
	}
	
	
	@Test
	public void testPerson(){
		Person person = (Person)ctx.getBean("person");
		
		person.say();
	}

}
