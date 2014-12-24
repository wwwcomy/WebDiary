package com.iteye.wwwcomy.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.iteye.wwwcomy.model.User;
import com.iteye.wwwcomy.service.impl.DiaryServiceImpl;

@Controller
@SessionAttributes("loginUser")
public class DiaryController {
    @Resource
    private DiaryServiceImpl diaryService;

    // @ResponseBody
    // @RequestMapping(value = "saveDiary.do")
    // public Object saveDiary(Date date, Date lastUpdateDate, String content, HttpSession session, ModelAndView view) {
    // User user = (User) session.getAttribute("loginUser");
    // diaryService.createDiary(date, lastUpdateDate, content, user);
    // Map<String, String> map = new HashMap<String, String>();
    // map.put("success", "true");
    // return map;
    // }

    @ResponseBody
    @RequestMapping(value = "saveDiary.do")
//    public Object saveDiaryForAjax(@RequestBody String json, HttpSession session, ModelAndView view) {
    public Object saveDiaryForAjax(@RequestBody Map json, HttpSession session, ModelAndView view) {
        User user = (User) session.getAttribute("loginUser");
//        JSONObject jsonObj = JSONObject.parseObject(json);
//        Date date = jsonObj.getDate("date");
//        Date lastUpdateDate = jsonObj.getDate("lastUpdateDate");
//        String content = jsonObj.getString("content");
//        diaryService.createDiary(date, lastUpdateDate, content, user);
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
