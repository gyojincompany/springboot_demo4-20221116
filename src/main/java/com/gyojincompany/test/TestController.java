package com.gyojincompany.test;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gyojincompany.test.dao.IDao;

@Controller
public class TestController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/join")
	public String joinPage() {
		
		return "join";
	}
	
	@RequestMapping(value = "/joinMember")
	public String joinMember(HttpServletRequest request, Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		String memail = request.getParameter("memail");
		
		dao.memberJoin(mid, mpw, mname, memail);//DB에 회원정보 삽입
		
		model.addAttribute("memberID", mid);
		
		return "joinOk";
	}
	
	
}
