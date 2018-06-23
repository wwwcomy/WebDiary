package com.iteye.wwwcomy.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iteye.wwwcomy.dao.DiaryRepository;
import com.iteye.wwwcomy.model.Diary;
import com.iteye.wwwcomy.model.User;
import com.iteye.wwwcomy.model.exception.EntityNotFoundException;
import com.iteye.wwwcomy.model.exception.MethodNotImplementException;

@Service
public class DiaryServiceImpl {
	@Autowired
	private DiaryRepository diaryRepository;

	public Diary createDiary(Date date, Date lastUpdateDate, String content, User user) {
		Diary diary = new Diary();
		diary.setContent(content);
		diary.setUserId(user.getId());
		diary.setDate(date);
		return diaryRepository.save(diary);
	}

	public Diary createDiary(Diary diary) {
		return diaryRepository.save(diary);
	}

	@Transactional
	public Diary updateDiary(long id, Diary diary, User user) {
		Diary existingDiary = diaryRepository.findOne(id);
		if (existingDiary == null) {
			throw new EntityNotFoundException("The diary is not found!");
		}
		existingDiary.update(diary);
		return diaryRepository.save(diary);
	}

	public Diary getDiaryById(long id) {
		return diaryRepository.findOne(id);
	}

	public Diary getDiary(User user, Date date) {
		// TODO implementation
		// return diaryDao.getByDate(user, date);
		throw new MethodNotImplementException();
	}

	@Transactional
	public List<Diary> getAllDiaryByUser(User user) {
		// TODO implementation
		// return diaryDao.getByDate(user, date);
		throw new MethodNotImplementException();
	}

	@Transactional
	public List<Diary> getAllDiary() {
		return diaryRepository.findAll();
	}

}
