package com.datayang.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.datayang.App;
import com.datayang.pojo.Dome;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class DomeServiceTest {
	@Resource
	public DomeService service;

	@Test
	public void testFindDomeById() {
		Dome dome = service.findDomeById(1);
		System.out.println(dome.getName());
	}

}
