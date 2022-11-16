package com.gyojincompany.test;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gyojincompany.test.dao.IDao;
import com.gyojincompany.test.dto.MemberDto;

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
	
	@RequestMapping(value = "/memberList")
	public String memberlist(Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		ArrayList<MemberDto> memberDtos = dao.memberList();
		
		//memberDtos.get(0).getMname();//첫번째 가입회원의 이름 추출
		
		model.addAttribute("memberList", memberDtos);	
		
		return "memberList";
	}
	
	
}
