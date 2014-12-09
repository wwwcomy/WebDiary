package com.iteye.wwwcomy.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.iteye.wwwcomy.model.User;
import com.iteye.wwwcomy.service.impl.DiaryServiceImpl;

@Controller
@SessionAttributes("loginUser")
public class DiaryController {
    @Autowired
    private DiaryServiceImpl diaryService;

    @ResponseBody
    @RequestMapping(value = "saveDiary.do", method = RequestMethod.POST)
    public Object saveDiary(Date date, Date lastUpdateDate, String content, HttpSession session, ModelAndView view) {
        User user = (User) session.getAttribute("loginUser");
        diaryService.createDiary(date, lastUpdateDate, content, user);
        Map<String, String> map = new HashMap<String, String>();
        map.put("success", "true");
        return map;
    }

    public DiaryServiceImpl getDiaryService() {
        return diaryService;
    }

    public void setDiaryService(DiaryServiceImpl diaryService) {
        this.diaryService = diaryService;
    }
}
