package com.iteye.wwwcomy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iteye.wwwcomy.model.Diary;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext.xml" })
public class DiaryServiceImplTest {

    @Resource
    DiaryServiceImpl diaryService;

    @Test
    public void canGetAllDiary() {
        List<Diary> diaries = diaryService.getAllDiary();
        Assert.assertTrue(diaries.size() > 0);
    }

    public DiaryServiceImpl getDiaryService() {
        return diaryService;
    }

    public void setDiaryService(DiaryServiceImpl diaryService) {
        this.diaryService = diaryService;
    }
}
