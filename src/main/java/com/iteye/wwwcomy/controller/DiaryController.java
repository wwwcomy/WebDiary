package com.iteye.wwwcomy.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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

import com.iteye.wwwcomy.model.Diary;
import com.iteye.wwwcomy.model.User;
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
	public Diary createDiary(@RequestBody Diary inputDiary, String content, HttpSession session, ModelAndView view) {
		User user = (User) session.getAttribute("loginUser");
		// TODO user handling
		inputDiary.setUserId(1);
		diaryService.createDiary(inputDiary);
		return inputDiary;
	}

	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Diary getDiary(@PathVariable long id, HttpSession session, ModelAndView view) {
		User user = (User) session.getAttribute("loginUser");
		Diary diary = diaryService.getDiaryById(id);
		return diary;
	}

	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Diary updateDiary(@PathVariable long id, @RequestBody Diary diary, HttpSession session,
			ModelAndView view) {
		User user = (User) session.getAttribute("loginUser");
		Diary result = diaryService.updateDiary(id, diary, user);
		return result;
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
	 * Gets all the diary's date list. Return a map like : diary date<--> ID
	 * 
	 * 
	 * @param session
	 * @param view
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "/date/{param}", method = RequestMethod.GET)
	public Object getDiaryDateList(@PathVariable String param, HttpSession session, ModelAndView view,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		LOGGER.info("Getting diary date list.");
		User user = (User) session.getAttribute("loginUser");
		// TODO Change getAllDiary to getAllDiaryByUser
		List<Diary> diaries = diaryService.getAllDiary();
		Map<String, Long> dateIdMap = new TreeMap<String, Long>();
		for (Diary diary : diaries) {
			String sDate = DateUtil.format(diary.getDate(), "yyyy年-MM月-dd日");
			dateIdMap.put(sDate, diary.getId());
		}
		return dateIdMap;
	}

	public DiaryServiceImpl getDiaryService() {
		return diaryService;
	}

	public void setDiaryService(DiaryServiceImpl diaryService) {
		this.diaryService = diaryService;
	}
}
