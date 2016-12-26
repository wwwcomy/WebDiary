package com.iteye.wwwcomy.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iteye.wwwcomy.dao.DiaryDao;
import com.iteye.wwwcomy.model.Diary;
import com.iteye.wwwcomy.model.User;
import com.iteye.wwwcomy.model.dto.DiaryDTOForRequest;

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
    public Diary updateDiary(String id, DiaryDTOForRequest dto, User user) {
        Diary diary = diaryDao.findById(id);
        diary.setContent(dto.getContent());
        diary.setUser(user);
        diary.setDate(dto.getDate());
        diary.setLastUpdateDate(new Date());
        diary.setTitle(dto.getTitle());
        diary.setWeather(dto.getWeather());
        diaryDao.update(diary);
        return diary;
    }

    @Transactional
    public Diary getDiaryById(String id) {
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
