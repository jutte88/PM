<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import ="java.sql.*" %>

<%
	request.setCharacterEncoding("euc-kr");
	String name = request.getParameter("Game_name");
	String choose1 = request.getParameter("choose1");
	String chosse2 = request.getParameter("choose2");
	
	Connection con = null;
	PreparedStatement pstmt =null;
	ResultSet rs =null;
	
	try{
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "pm";
		String password = "pm";
		
		con = DriverManager.getConnection(url, user, password);	
		String sql = "";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		
		
	}finally{
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="../css/balancegame.css">
<title>Insert title here</title>
</head>
<body>
  <h1>BALANCE GAME</h1>
  <h3>질문 내용</h3>
  <section>
    <article class="c">
      <div class="choose">
        선택지 A
      </div>
      <div class="vs">
        VS
      </div>
      <div class ="choose">
        선택지 B
      </div>
    </article>
    <article class="b">
      <button class="button">
        선택지 A
      </button>
      <button class="button">
        선택지 B
      </button>
    </article>
    <div>
      결과 표시창
    </div>
  </section>

</body>
</html>