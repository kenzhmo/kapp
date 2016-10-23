package com.kapp.webtest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kapp.WebTestJarApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = WebTestJarApplication.class)
@WebAppConfiguration
public class WebTestJarApplicationTests {

	@Test
	public void contextLoads() {
	}

}
