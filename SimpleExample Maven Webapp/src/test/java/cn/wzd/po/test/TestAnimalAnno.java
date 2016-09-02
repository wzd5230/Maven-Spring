package cn.wzd.po.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.wzd.po.Animal;

public class TestAnimalAnno {
	private ClassPathXmlApplicationContext ctx;
	
	@Before
	public void setUp(){
		String configLocation = "classpath:ApplicationContext.xml";
		this.ctx = new ClassPathXmlApplicationContext(configLocation);
	}
	
	
	@Test
	public void testAnimal(){
		Animal animal = (Animal)ctx.getBean("animal");
		
		animal.setName("哈士奇");
		animal.setAge(2);
		
		animal.say();
	}
}
