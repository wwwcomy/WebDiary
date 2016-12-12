package com.iteye.wwwcomy.dao.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.iteye.wwwcomy.dao.DiaryDao;
import com.iteye.wwwcomy.model.Diary;
import com.iteye.wwwcomy.model.User;

@Repository
public class DiaryDaoImpl implements DiaryDao {

    @Override
    public Diary getByDate(User user, Date date) {
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Diary> getAllDiaryByUser(User user) {
        return Collections.EMPTY_LIST;
    }

    /**
     * @param user
     * @return
     * @Deprecated For test only
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Diary> getAllDiary() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public Diary save(Diary entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(Diary entity) {
        // TODO Auto-generated method stub

    }

    @Override
    public Diary getById(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Diary> getByIds(String[] ids) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Diary> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

}
