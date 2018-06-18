package com.iteye.wwwcomy.model;

import java.io.IOException;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iteye.wwwcomy.dao.DiaryRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext.xml" })
public class DiaryTest {
	@Autowired
	private DiaryRepository diaryRepository;

	@Test
	public void createDiary() {
		Diary d = new Diary();
		d.setContent("Content");
		d.setDate(new Date());
		d.setLastUpdateDate(new Date());
		d.setUser(new User());
		diaryRepository.save(d);
	}

	@Test
	public void toJson() throws Exception {
		Diary d = new Diary();
		d.setContent("Content");
		d.setDate(new Date());
		d.setLastUpdateDate(new Date());
		d.setUser(new User());
		d.setId(123);
		d.setTitle("title");
		d.setWeather("weather");
		JsonGenerator jsonGenerator = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			jsonGenerator = objectMapper.getFactory().createGenerator(System.out, JsonEncoding.UTF8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		jsonGenerator.writeObject(d);
	}

}
