package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.sql.MyConnection;


/**
 * Servlet implementation class Connection
 */
@WebServlet("/Connection")
public class gameConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public gameConnection() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		String id = request.getParameter("id");	
		
		String result = null;
		//DB연결
		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		
		String selectGameIndex = "SELECT q.question_name \r\n"
				+ "FROM question q JOIN choice d ON (q.question_num = d.question_num)\r\n"
				+ "WHERE q.question_num in 1";
		try {
			con = MyConnection.getConnection();
			pstmt = con.prepareStatement(selectGameIndex);
//			pstmt.setString(1,id);
			rs=pstmt.executeQuery();
			if(!rs.next()) {
				result = "{\"status\":1, \"msg\" : \"사용 가능한 아이디입니다\"}";
			
			}
			}catch (SQLException e) {
				e.printStackTrace();
				String msg = e.getMessage();
				result = "{\"status\":0, \"msg\" : \""+ msg + "\"}";
			}finally {
				MyConnection.close(rs,  pstmt, con);
		}
			response.setContentType("application/json;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(result);
		}

	

}
