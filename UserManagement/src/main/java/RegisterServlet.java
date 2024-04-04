import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	
	private final static String query="insert into user(Name,Email,Mobile,DOB,Gender,City,Projectname,StartDate,EndDate) values(?,?,?,?,?,?,?,?,?)";
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//get printwriter
	PrintWriter pw=resp.getWriter();
	//set content type
	resp.setContentType("text/html");
	//link the boostrap
	pw.println("<link href='css/bootstrap.css'  rel='stylesheet'></link>");
	// get values
	String name =req.getParameter("userName");
	String email =req.getParameter("email");
	String mobile =req.getParameter("mobile");
	String dob =req.getParameter("dob");
	String gender=req.getParameter("gender");
	String city =req.getParameter("city");
	String projectname =req.getParameter("projectname");
	String Sdate =req.getParameter("Sdate");
	String Edate =req.getParameter("Edate");
	
	//load the jdbc driver
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	//genarate the connection 
	try(Connection con=DriverManager.getConnection("jdbc:mysql:///book","root","");
			PreparedStatement ps=con.prepareStatement(query)  ) {
		//set the values
		ps.setString(1,name);
		ps.setString(2,email);
		ps.setString(3,mobile);
		ps.setString(4,dob);
		ps.setString(5,gender);
		ps.setString(6,city);
		ps.setString(7,projectname);
		ps.setString(8,Sdate);
		ps.setString(9,Edate);
		//execute the quries
		int count =ps.executeUpdate() ;
		pw.println("<div class='card' style='margin:auto,width:300px,margin-top:100px'>");
		if(count==1) {
			pw.println("<h2 class='bg-danger text-light text-center'>Record is Registered sucessfully</h2>");
		}else {
			pw.println("<h2 class='bg-danger text-light text-center'>Record is not Registered sucessfully</h2>");
		}
	}
	catch(SQLException se) {
		pw.println("<h2 class='bg-danger text-light text-center'>"+se.getMessage()+"</h2>");
		se.printStackTrace();
	}
	catch(Exception e) {
		e.printStackTrace();
		}
	pw.println("<a href='home.html'><button class='btn-outline-success'>Home</button></a>");
	pw.println("&nbsp;&nbsp;");
	pw.println("<a href='showdata'><button class='btn-outline-success'>Show Users</button></a>");
	
	pw.println("</div>");
	//colse the stream
	pw.close();
}

@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
}
	

