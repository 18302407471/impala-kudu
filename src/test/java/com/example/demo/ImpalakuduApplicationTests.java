package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImpalakuduApplicationTests {

	@Autowired
	private JdbcTemplate impalaJdbcTemplate;

	@Test
	public void contextLoads() {
		String sql="SELECT * FROM platformstatusinfo";
		Long startTime = System.currentTimeMillis();
		System.out.println();
		List<Map<String, Object>> maps = impalaJdbcTemplate.queryForList(sql);
		System.out.println(maps.size());
		System.out.println("-------------------------");
		System.out.println(System.currentTimeMillis()-startTime);

//		for (Map<String, Object> map : maps) {
//			System.out.println(map.toString());
//		}
	}

}
