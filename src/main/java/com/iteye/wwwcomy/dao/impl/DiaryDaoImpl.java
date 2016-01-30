package com.iteye.wwwcomy.dao.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.iteye.wwwcomy.dao.DiaryDao;
import com.iteye.wwwcomy.model.Diary;
import com.iteye.wwwcomy.model.User;

@Repository
public class DiaryDaoImpl extends BaseDaoImpl<Diary> implements DiaryDao {

    @SuppressWarnings("unchecked")
    @Override
    public Diary getByDate(User user, Date date) {
        List<Diary> list = getCurrentSession()
                .createQuery("FROM " + getClazz().getSimpleName() + " WHERE userId=(:userId) and date=(:date)")
                .setParameter("userId", String.valueOf(user.getUserid())).setParameter("date", date).list();
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Diary> getAllDiaryByUser(User user) {
        List<Diary> list = getCurrentSession()
                .createQuery("FROM " + getClazz().getSimpleName() + " WHERE userId=(:userId)")
                .setParameter("userId", String.valueOf(user.getUserid())).list();
        if (list != null && list.size() > 0) {
            return list;
        }
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
        List<Diary> list = getCurrentSession().createQuery("FROM " + getClazz().getSimpleName()).list();
        if (list != null && list.size() > 0) {
            return list;
        }
        return Collections.EMPTY_LIST;
    }

}
