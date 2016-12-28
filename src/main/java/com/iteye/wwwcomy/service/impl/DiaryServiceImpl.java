package com.iteye.wwwcomy.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iteye.wwwcomy.dao.DiaryDao;
import com.iteye.wwwcomy.model.Diary;
import com.iteye.wwwcomy.model.User;
import com.iteye.wwwcomy.model.exception.NotFoundException;

@Service
public class DiaryServiceImpl {
	@Resource
	private DiaryDao diaryDao;

	@Transactional
	public void createDiary(Date date, Date lastUpdateDate, String content, User user) {
		Diary diary = new Diary();
		diary.setContent(content);
		diary.setUser(user);
		diary.setDate(date);
		diary.setLastUpdateDate(lastUpdateDate);
		diaryDao.save(diary);
	}

	@Transactional
	public void createDiary(Diary diary) {
		diaryDao.save(diary);
	}

	@Transactional
	public Diary updateDiary(long id, Diary diary, User user) {
		Diary existingDiary = diaryDao.findById(id);
		if (existingDiary == null) {
			throw new NotFoundException("The diary is not found!");
		}
		existingDiary.update(diary);
		diaryDao.update(diary);
		return diary;
	}

	@Transactional
	public Diary getDiaryById(long id) {
		return diaryDao.findById(id);
	}

	public Diary getDiary(User user, Date date) {
		return diaryDao.getByDate(user, date);
	}

	@Transactional
	public List<Diary> getAllDiaryByUser(User user) {
		return diaryDao.getAllDiaryByUser(user);
	}

	@Transactional
	public List<Diary> getAllDiary() {
		return diaryDao.getAllDiary();
	}

	public DiaryDao getDiaryDao() {
		return diaryDao;
	}

	public void setDiaryDao(DiaryDao diaryDao) {
		this.diaryDao = diaryDao;
	}

}
