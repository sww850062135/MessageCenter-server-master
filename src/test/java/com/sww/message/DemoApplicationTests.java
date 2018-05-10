package com.sww.message;

import com.sww.message.entity.Email;
import com.sww.message.mapper.EmailMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;



@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private EmailMapper emailMapper;
	@Test
	public void test() {
		/*Map<String, Object> map = new HashMap<>();
		map.put("from","13576132451@163.com");
		map.put("to", "13576132451@163.com");
		map.put("subject", "test");
		map.put("text", "test");
		map.put("sendTime", new Date());
		emailMapper.insertByMap(map);*/
		//emailMapper.insert("13576132451@163.com", "test2", "test", new Date());
		List<Email> emailList = emailMapper.getEmailListBySubject("test");
		System.out.println(emailList);
	}

}
