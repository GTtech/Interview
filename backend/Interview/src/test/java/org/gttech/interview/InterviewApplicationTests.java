package org.gttech.interview;

import org.gttech.interview.entity.TCity;
import org.gttech.interview.mapper.TCityMapper;
import org.gttech.interview.util.SnowFlake;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InterviewApplicationTests {

	@Autowired
	TCityMapper tCityMapper;

	@Value("${snowflake.workerId}")
	long workerId;

	@Value("${snowflake.datacenterId}")
	long datacenterId;

	@Test
	public void contextLoads() {
		SnowFlake tmpSnowFlake = SnowFlake.getInstance(workerId, datacenterId);
		TCity tCity = new TCity();
		tCity.setId(tmpSnowFlake.nextId());
		tCity.setName("Sydney");
		tCityMapper.insert(tCity);

		tCity = new TCity();
		tCity.setId(tmpSnowFlake.nextId());
		tCity.setName("Melbourne");
		tCityMapper.insert(tCity);

		tCity = new TCity();
		tCity.setId(tmpSnowFlake.nextId());
		tCity.setName("Wollongong");
		tCityMapper.insert(tCity);
	}

}
