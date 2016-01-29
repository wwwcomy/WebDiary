package com.iteye.wwwcomy.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.iteye.wwwcomy.model.Diary;
import com.iteye.wwwcomy.model.User;
import com.iteye.wwwcomy.model.dto.DiaryDTOForRequest;
import com.iteye.wwwcomy.service.impl.DiaryServiceImpl;

/**
 * @author wwwcomy
 *
 *         TODO Use Spring Security to achieve access control. Avoid 水平越权,垂直越权.
 *         Session may not be needed, user information can be get from
 *         SecurityContextHolder.
 */
@Controller
@SessionAttributes("loginUser")
@RequestMapping(value = "/diary", produces = "application/json")
public class DiaryController {
    @Resource
    private DiaryServiceImpl diaryService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
    public Diary saveDiaryForAjax(@RequestBody DiaryDTOForRequest dto, String content, HttpSession session,
            ModelAndView view) {
        User user = (User) session.getAttribute("loginUser");
        Diary diary = diaryService.createDiary(dto, user);
        return diary;
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Diary getDiary(@PathVariable String id, HttpSession session, ModelAndView view) {
        User user = (User) session.getAttribute("loginUser");
        Diary diary = diaryService.getDiaryById(id);
        return diary;
    }

    /**
     * Gets all the diary list
     * 
     * @param session
     * @param view
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Object loadDiaryList(HttpSession session, ModelAndView view) {
        User user = (User) session.getAttribute("loginUser");
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
