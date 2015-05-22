package com.iteye.wwwcomy.dao;

import java.util.Date;

import com.iteye.wwwcomy.model.Diary;
import com.iteye.wwwcomy.model.User;

public interface DiaryDao extends BaseDao<Diary> {

	Diary getByDate(User user, Date date);

}
