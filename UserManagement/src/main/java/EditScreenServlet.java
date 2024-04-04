import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/editurl")
public class EditScreenServlet extends HttpServlet {
	private final static String query="select Name,Email,Mobile,DOB,Gender,City,Projectname,StartDate,EndDate from user";
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	//get printwriter
	PrintWriter pw=res.getWriter();
	//set content type
	res.setContentType("text/html");
	//get id 
	//get the values
	int ID=Integer.parseInt(req.getParameter("ID"));
	//link the boostrap
	pw.println("<link href='css/bootstrap.css'  rel='stylesheet'></link>");
	pw.println("<marquee><h2 class='text-primary'>User Data...</h2></marquee>");
	//load the jdbc driver
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	}
	catch(ClassNotFoundException cnf) {
		cnf.printStackTrace();
	}
	//genarate the connection 
	try(Connection con=DriverManager.getConnection("jdbc:mysql:///book","root","");
			PreparedStatement ps=con.prepareStatement(query)  ) {
		//set value
		ps.setInt(1, ID);
		//result set
		ResultSet rs=ps.executeQuery();
		rs.next();
		pw.println("<div style='margin:auto,width:600px;margin-top:100px'>");
		pw.println("<form action='edit?ID="+ID+"' method='post'>");
		pw.println("<table class='table table-hover table-striped'>");
		pw.println("<tr>");
		pw.println("<td>Name</td>");
		pw.println("<td><input type='text' name='name' value='"+rs.getString(1)+"'></td>");
		pw.println("</tr>");
		pw.println("<tr>");
		pw.println("<td>Email</td>");
		pw.println("<td><input type='email' name='email' value='"+rs.getString(2)+"'></td>");
		pw.println("</tr>");
		pw.println("<tr>");
		pw.println("<td>Mobile</td>");
		pw.println("<td><input type='text' name='mobile' value='"+rs.getString(3)+"'></td>");
		pw.println("</tr>");
		pw.println("<tr>");
		pw.println("<td>DOB</td>");
		pw.println("<td><input type='date' name='dob' value='"+rs.getString(4)+"'></td>");
		pw.println("</tr>");
		pw.println("<tr>");
		pw.println("<td>Gender</td>");
		pw.println("<td><input type='text' name='gender' value='"+rs.getString(5)+"'></td>");
		pw.println("</tr>");
		pw.println("<tr>");
		pw.println("<td>City</td>");
		pw.println("<td><input type='text' name='city' value='"+rs.getString(6)+"'></td>");
		pw.println("</tr>");
		pw.println("<tr>");
		pw.println("<td>Projectname</td>");
		pw.println("<td><input type='text' name='projectname' value='"+rs.getString(7)+"'></td>");
		pw.println("</tr>");
		pw.println("<tr>");
		pw.println("<td>StartDate</td>");
		pw.println("<td><input type='date' name='Sdate' value='"+rs.getString(8)+"'></td>");
		pw.println("</tr>");
		pw.println("<tr>");
		pw.println("<td>EndDate</td>");
		pw.println("<td><input type='date' name='Edate' value='"+rs.getString(9)+"'></td>");
		pw.println("</tr>");
		pw.println("<tr>");
		pw.println("<td><button type='submit' class='btn-outline-success'>Update</button></td>");
		pw.println("<td><button type='reset' class='btn-outline-danger'>Cancel</button></td>");
		pw.println("</tr>");
		pw.println("</table>");
		pw.println("</form>");
	}
	catch(SQLException se) {
		pw.println("<h2 class='bg-danger text-light text-center'>"+se.getMessage()+"</h2>");
		se.printStackTrace();
	}
	catch(Exception e) {
		e.printStackTrace();
		}
	pw.println("<a href='home.html'><button class='btn-outline-success'>Home</button></a>");
	
	pw.println("</div>");
	//colse the stream
	pw.close();
}

@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
}
}


