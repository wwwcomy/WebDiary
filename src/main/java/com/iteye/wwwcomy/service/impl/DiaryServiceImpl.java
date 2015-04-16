package com.iteye.wwwcomy.service.impl;

import java.util.Date;

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
    public void createDiary(DiaryDTOForRequest dto, User user) {
        Diary diary = new Diary();
        diary.setContent(dto.getContent());
        diary.setUser(user);
        diary.setDate(dto.getDate());
        diary.setLastUpdateDate(dto.getLastUpdateDate());
        diaryDao.save(diary);
    }

    public DiaryDao getDiaryDao() {
        return diaryDao;
    }

    public void setDiaryDao(DiaryDao diaryDao) {
        this.diaryDao = diaryDao;
    }

}
