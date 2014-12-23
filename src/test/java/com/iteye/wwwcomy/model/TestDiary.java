package com.iteye.wwwcomy.model;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.iteye.wwwcomy.dao.DiaryDao;

public class TestDiary {
    @Resource
    private DiaryDao diaryDao;
    @Test
    public void createDiary() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Diary d = new Diary();
        d.setContent("Content");
        d.setDate(new Date());
        d.setLastUpdateDate(new Date());
        d.setUser(new User());
        diaryDao.save(d);
    }
}
