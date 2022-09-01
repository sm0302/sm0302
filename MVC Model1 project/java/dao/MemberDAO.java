package com.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import com.jsp.dto.MemberVO;

import util.DBManager;


public class MemberDAO {
	
	private MemberDAO() {
		
	}
	private static MemberDAO instance = new MemberDAO();
	public static MemberDAO getInstance() {
		return instance;
	}
	public Connection getConnection() throws Exception{
		Connection conn = null;
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		conn = ds.getConnection();
		return conn;
	}
	public int idCheck(String id,String pw) {
		int result = -1;
		String sql="select pw from portfolio where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("pw")!=null&&rs.getString("pw").equals(pw)) {
					result=1;
				}else {
					result=0;
				}
			}else {
				result=-1;
			}
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
		
		
	}
	public MemberVO getMember(String id) {
		MemberVO mVo = new MemberVO();
		Connection conn = null;
		String sql="select * from portfolio where id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String name = rs.getString("name");
				mVo.setName(name);
				
				String nickname = rs.getString("nickname");
				mVo.setNickname(nickname);
				
				String pass = rs.getString("pass");
				mVo.setPass(pass);
				
				String id1 = rs.getString("id");
				mVo.setId(id1);
				
				String pw = rs.getString("pw");
				mVo.setPw(pw);
				
				String email = rs.getString("email");
				mVo.setEmail(email);

				String post = rs.getString("post");
				mVo.setPost(post);
				
				String address = rs.getString("address");
				mVo.setAddress(address);
				
				String phone = rs.getString("phone");
				mVo.setPhone(phone);
				
				String job = rs.getString("job");
				mVo.setJob(job);

				String receive = rs.getString("receive");
				mVo.setReceive(receive);
				
				String interest= rs.getString("interest");
				mVo.setInterest(interest);
			}
		}catch(Exception e){
			System.out.println("아니야"+e);
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return mVo;
	}
	public void insertMember(MemberVO mVo) {
		String sql="insert into portfolio values(?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getName());
			pstmt.setString(2, mVo.getPass());
			pstmt.setString(3, mVo.getId());
			pstmt.setString(4, mVo.getPw());
			pstmt.setString(5, mVo.getEmail());
			pstmt.setString(6, mVo.getReceive());
			pstmt.setString(7, mVo.getPost());
			pstmt.setString(8, mVo.getAddress());
			pstmt.setString(9, mVo.getPhone());
			pstmt.setString(10, mVo.getJob());
			pstmt.setString(11, mVo.getNickname());
			pstmt.setString(12, mVo.getInterest());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	public MemberVO showMember(HttpServletRequest request) {
		MemberVO mVo = new MemberVO();
		String name = request.getParameter("name");
		mVo.setName(name);
		
		String nickname = request.getParameter("nickname");
		mVo.setNickname(nickname);
		
		String idNum = request.getParameter("idNum");
		String idNum1 = request.getParameter("idNum1");
		mVo.setPass(idNum+"-"+idNum1);
		
		String id = request.getParameter("id");
		mVo.setId(id);
		
		String pw = request.getParameter("pw1");
		mVo.setPw(pw);
		
		String email = request.getParameter("email");
		String email1 = request.getParameter("email1");
		String emailValue = email+"@"+email1;
		mVo.setEmail(emailValue);

		String post = request.getParameter("postNum");
		mVo.setPost(post);
		
		String address = request.getParameter("address");
		String address1 = request.getParameter("address1");
		mVo.setAddress(address+"\t"+address1);
		
		String num = request.getParameter("num");
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		String number = num+"-"+num1+"-"+num2;
		mVo.setPhone(number);
		
		String[] job = request.getParameterValues("job");
		String mini ="";
		for(String i : job){
			int n = Integer.parseInt(i);
			switch(n){
			case 1:
				mini+="컴퓨터/인터넷 ";
				break;
			case 2:
				mini+="언론 ";
				break;
			case 3: 
				mini+="공무원 ";
				break;
			case 4:
				mini+="학생 ";
				break;
			case 5:
				mini+="축구선수 ";
				break;
			default:
				break;
			}
		}
		mVo.setJob(mini);
		
		String receive = request.getParameter("receive");
		String a=null;
		if(receive.equals("on")){
			a = "수신";
			mVo.setReceive(a);
		}
		else if(receive.equals("off")){
			a = "수신거부";
			mVo.setReceive(a);
		}
		
		String[] interest= request.getParameterValues("interest");
		String sub = "";
		for(String i : interest){
			switch(i){
			case "computer game":
				sub+="컴퓨터 게임 ";
				break;
			case "cook":
				sub+="요리 ";
				break;
			case "shopping":
				sub+="쇼핑 ";
				break;
			case "draw": 
				sub+="그림 그리기 ";
				break;
			case "book":
				sub+="책 읽기 ";
				break;
			case "sports":
				sub+="스포츠 ";
				break;
			default:
				break;
			}
		}
		mVo.setInterest(sub);
		return mVo;
	}
	public void updateMember(MemberVO mVo, String nickname) {
		String sql="update portfolio set name=?, pass=?, id=?, pw=?, email=?, receive=?, post=?, address=?, phone=?, job=?, nickname=?, interest=? where nickname=?";
		Connection conn =null;
		PreparedStatement pstmt = null;
		conn = DBManager.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getName());
			pstmt.setString(2, mVo.getPass());
			pstmt.setString(3, mVo.getId());
			pstmt.setString(4, mVo.getPw());
			pstmt.setString(5, mVo.getEmail());
			pstmt.setString(6, mVo.getReceive());
			pstmt.setString(7, mVo.getPost());
			pstmt.setString(8, mVo.getAddress());
			pstmt.setString(9, mVo.getPhone());
			pstmt.setString(10, mVo.getJob());
			pstmt.setString(11, mVo.getNickname());
			pstmt.setString(12, mVo.getInterest());
			pstmt.setString(13, nickname);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	public MemberVO updateControl(HttpServletRequest request) {
		MemberVO mVo = new MemberVO();
		String name = request.getParameter("name");
		mVo.setName(name);
		
		String nickname = request.getParameter("nickname");
		mVo.setNickname(nickname);
		
		String pass = request.getParameter("pass");
		mVo.setPass(pass);
		
		String id = request.getParameter("id");
		mVo.setId(id);
		
		String pw = request.getParameter("pw");
		mVo.setPw(pw);
		
		String email = request.getParameter("email");
		mVo.setEmail(email);

		String post = request.getParameter("post");
		mVo.setPost(post);
		
		String address = request.getParameter("address");
		mVo.setAddress(address);
		
		String phone = request.getParameter("phone");
		mVo.setPhone(phone);
		
		String[] job = request.getParameterValues("job");
		String mini ="";
		for(String i : job){
			int n = Integer.parseInt(i);
			switch(n){
			case 1:
				mini+="컴퓨터/인터넷 ";
				break;
			case 2:
				mini+="언론 ";
				break;
			case 3: 
				mini+="공무원 ";
				break;
			case 4:
				mini+="학생 ";
				break;
			case 5:
				mini+="축구선수 ";
				break;
			default:
				break;
			}
		}
		mVo.setJob(mini);
		
		String receive = request.getParameter("receive");
		String a=null;
		if(receive.equals("on")){
			a = "수신";
			mVo.setReceive(a);
		}
		else if(receive.equals("off")){
			a = "수신거부";
			mVo.setReceive(a);
		}
		
		String[] interest= request.getParameterValues("interest");
		String sub = "";
		for(String i : interest){
			switch(i){
			case "computer game":
				sub+="컴퓨터 게임 ";
				break;
			case "cook":
				sub+="요리 ";
				break;
			case "shopping":
				sub+="쇼핑 ";
				break;
			case "draw": 
				sub+="그림 그리기 ";
				break;
			case "book":
				sub+="책 읽기 ";
				break;
			case "sports":
				sub+="스포츠 ";
				break;
			default:
				break;
			}
		}
		mVo.setInterest(sub);
		return mVo;
	}
	public void deleteMember(String nickname) {
		String sql="delete from portfolio where nickname=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBManager.getConnection();
		System.out.println(nickname);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nickname);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
		
	}
	
}
