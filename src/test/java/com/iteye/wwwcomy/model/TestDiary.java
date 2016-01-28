package com.iteye.wwwcomy.model;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iteye.wwwcomy.dao.DiaryDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext.xml" })
public class TestDiary {
    @Resource
    private DiaryDao diaryDao;

    @Test
    @Transactional
    public void createDiary() {
        Diary d = new Diary();
        d.setContent("Content");
        d.setDate(new Date());
        d.setLastUpdateDate(new Date());
        d.setUser(new User());
        System.out.println(diaryDao.save(d));
    }

    @Test
    @Transactional
    public void loadDiary() {
        User user = new User();
        user.setUserid(1);
        Diary d = diaryDao.getByDate(user, new Date());
        System.out.println(d);
    }

    @Test
    public void toJson() throws Exception {
        Diary d = new Diary();
        d.setContent("Content");
        d.setDate(new Date());
        d.setLastUpdateDate(new Date());
        d.setUser(new User());
        d.setId("123");
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

    public DiaryDao getDiaryDao() {
        return diaryDao;
    }

    public void setDiaryDao(DiaryDao diaryDao) {
        this.diaryDao = diaryDao;
    }
}
