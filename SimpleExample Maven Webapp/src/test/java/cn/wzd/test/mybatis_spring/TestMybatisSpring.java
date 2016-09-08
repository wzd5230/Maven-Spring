package cn.wzd.test.mybatis_spring;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.wzd.ssm.mapper.UserMapper;
import cn.wzd.ssm.po.User;

public class TestMybatisSpring {
	
	private ApplicationContext ctx;

	@Before
	public void setUp() {
		this.ctx = new ClassPathXmlApplicationContext("classpath:spring/ApplicationContext.xml");
	}
	
	@Test
	public void testMybatisSpring() throws Exception{
		UserMapper userMapper = (UserMapper) this.ctx.getBean("userMapper");
		
		User user = userMapper.selectByPrimaryKey(4);
		
		System.out.println("name: "+user.getUsername());
		
		
	}

}
