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

/**
 * Servlet implementation class Delete
 */
@WebServlet("/delete.do")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nickname = request.getParameter("nickname");
		MemberDAO mDao = MemberDAO.getInstance();
		mDao.deleteMember(nickname);
		HttpSession session = request.getSession();
		session.invalidate();
		HttpSession subSession = request.getSession();
		subSession.setAttribute("message", "È¸¿øÅ»Åð µÇ¾ú½À´Ï´Ù");
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
