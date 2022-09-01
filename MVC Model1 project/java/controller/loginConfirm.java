package com.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dao.MemberDAO;
import com.jsp.dto.MemberVO;

/**
 * Servlet implementation class loginConfirm
 */
@WebServlet("/Success.do")
public class loginConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String url = "login.jsp";
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		HttpSession session = request.getSession();
		MemberVO mVo = new MemberVO();
		MemberDAO mDao = MemberDAO.getInstance();
		mVo = mDao.getMember(id);
		session.setAttribute("loginUser", mVo);
		int result = mDao.idCheck(id, pw);
		if(result==1) {
			request.setAttribute("message", "로그인 성공");
			url="semiChat.jsp";
		}else if(result==0){
			request.setAttribute("message","패스워드가 틀립니다");
		}else if(result==-1){
			request.setAttribute("message", "존재하지 않는 회원입니다");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
