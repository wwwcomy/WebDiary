package com.iteye.wwwcomy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iteye.wwwcomy.model.Diary;

public interface DiaryRepository extends JpaRepository<Diary, Long> {

}
