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
 * Servlet implementation class MyPage
 */
@WebServlet("/update.do")
public class MyPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("update.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String nickname = request.getParameter("nick");
		HttpSession session = request.getSession();
		session.invalidate();
		MemberVO mVo = new MemberVO();
		MemberDAO mDao = MemberDAO.getInstance();
		mVo = mDao.updateControl(request);
		HttpSession subSession = request.getSession();
		subSession.setAttribute("loginUser", mVo);
		mDao.updateMember(mVo, nickname);
		RequestDispatcher dispatcher = request.getRequestDispatcher("semiChat.jsp");
		dispatcher.forward(request, response);
	}

}
