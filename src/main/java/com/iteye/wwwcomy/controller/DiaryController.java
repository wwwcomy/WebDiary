package com.iteye.wwwcomy.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.iteye.wwwcomy.model.Diary;
import com.iteye.wwwcomy.model.User;
import com.iteye.wwwcomy.model.dto.DiaryDTOForRequest;
import com.iteye.wwwcomy.service.impl.DiaryServiceImpl;
import com.iteye.wwwcomy.utils.DateUtil;

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

    private static final Logger LOGGER = LoggerFactory.getLogger(DiaryController.class);
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
    public List<Diary> getDiaryList(HttpSession session, ModelAndView view) {
        User user = (User) session.getAttribute("loginUser");
        return null;
    }

    /**
     * Gets all the diary's date list
     * 
     * @param session
     * @param view
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/date/{param}", method = RequestMethod.GET)
    public Object getDiaryDateList(@PathVariable String param, HttpSession session, ModelAndView view,
            HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) session.getAttribute("loginUser");
        // TODO Change getAllDiary ti getAllDiaryByUser
        List<Diary> diaries = diaryService.getAllDiary();
        Map<String, Map<String, Set<String>>> yearMap = new TreeMap<String, Map<String, Set<String>>>();
        for (Diary diary : diaries) {
            String sDate = DateUtil.format(diary.getDate(), "yyyy年-MM月-dd日");
            String[] seg = sDate.split("-");
            String year = seg[0];
            String month = seg[1];
            String day = seg[2];
            if (yearMap.get(year) != null) {
                Map<String, Set<String>> monthMap = yearMap.get(year);
                if (monthMap.get(month) != null) {
                    Set<String> daySet = monthMap.get(month);
                    if (daySet.contains(day)) {
                        // should not happen..
                        LOGGER.warn("Two diaries in ONE day..");
                    } else {
                        daySet.add(day);
                    }
                } else {
                    Set<String> daySet = new TreeSet<String>();
                    daySet.add(day);
                    monthMap.put(month, daySet);
                }
            } else {
                Map<String, Set<String>> monthMap = new TreeMap<String, Set<String>>();
                Set<String> daySet = new TreeSet<String>();
                daySet.add(day);
                monthMap.put(month, daySet);
                yearMap.put(year, monthMap);
            }
        }
        JSONArray jsonArray = generateJsonArray(yearMap);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(jsonArray.toJSONString());
        return null;
    }

    private JSONArray generateJsonArray(Map<String, Map<String, Set<String>>> yearMap) {
        JSONArray yearJsonArr = new JSONArray();
        Iterator<String> yearIter = yearMap.keySet().iterator();
        while (yearIter.hasNext()) {
            String year = yearIter.next();
            JSONObject yearJsonObj = new JSONObject();

            yearJsonObj.put("text", year);
            yearJsonObj.put("href", "#");

            JSONArray monthJsonArr = new JSONArray();

            Map<String, Set<String>> monthMap = yearMap.get(year);
            Iterator<String> monthIter = monthMap.keySet().iterator();
            while (monthIter.hasNext()) {
                String month = monthIter.next();
                JSONObject monthJsonObj = new JSONObject();
                monthJsonObj.put("text", month);
                monthJsonObj.put("href", "#");

                Set<String> days = monthMap.get(month);
                JSONArray daysJsonArr = new JSONArray();
                for (String day : days) {
                    JSONObject dayJsonObj = new JSONObject();
                    dayJsonObj.put("text", day);
                    dayJsonObj.put("href", "#");
                    JSONArray tagsArr = new JSONArray();
                    tagsArr.add("0");
                    dayJsonObj.put("tags", tagsArr);
                    daysJsonArr.add(dayJsonObj);
                }

                JSONArray tagsArr = new JSONArray();
                tagsArr.add(String.valueOf(daysJsonArr.size()));
                monthJsonObj.put("tags", tagsArr);
                monthJsonObj.put("nodes", daysJsonArr);
                JSONObject stateJson = new JSONObject();
                stateJson.put("expanded", true);
                monthJsonObj.put("state", stateJson);
                monthJsonObj.put("nodes", daysJsonArr);
                monthJsonArr.add(monthJsonObj);
            }

            JSONArray tagsArr = new JSONArray();
            tagsArr.add(String.valueOf(monthJsonArr.size()));
            yearJsonObj.put("tags", tagsArr);
            yearJsonObj.put("nodes", monthJsonArr);
            yearJsonArr.add(yearJsonObj);
        }
        return yearJsonArr;
    }

    public DiaryServiceImpl getDiaryService() {
        return diaryService;
    }

    public void setDiaryService(DiaryServiceImpl diaryService) {
        this.diaryService = diaryService;
    }
}
