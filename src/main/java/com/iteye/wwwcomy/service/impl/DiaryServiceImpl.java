package com.iteye.wwwcomy.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iteye.wwwcomy.dao.DiaryDao;
import com.iteye.wwwcomy.model.Diary;
import com.iteye.wwwcomy.model.User;

@Service
public class DiaryServiceImpl {
    @Autowired
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

    public DiaryDao getDiaryDao() {
        return diaryDao;
    }

    public void setDiaryDao(DiaryDao diaryDao) {
        this.diaryDao = diaryDao;
    }

}
