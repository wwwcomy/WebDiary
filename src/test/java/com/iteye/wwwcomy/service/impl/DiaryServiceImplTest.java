package com.iteye.wwwcomy.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iteye.wwwcomy.model.Diary;
import com.iteye.wwwcomy.model.User;

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

	@Test
	public void canFindById() {
		Diary diary = diaryService.getDiaryById(2);
		System.out.println(diary.getContent());
		Assert.assertNotNull(diary);
	}

	@Test
	public void canSaveDiary() {
		Diary diary = new Diary();
		diary.setContent("test_content");
		diary.setDate(new Date());
		diary.setLastUpdateDate(new Date());
		diary.setTitle("test_title");
		diary.setUserId(1);
		diaryService.createDiary(diary);
	}

	@Test
	public void canUpdateDiary() {
		Diary diary = new Diary();
		diary.setContent("updated content");
		diary.setTitle("更新title");
		diary.setUserId(1);
		User user = new User();
		diaryService.updateDiary(39, diary, user);
	}

	public DiaryServiceImpl getDiaryService() {
		return diaryService;
	}

	public void setDiaryService(DiaryServiceImpl diaryService) {
		this.diaryService = diaryService;
	}
}
