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
@WebServlet("/deleteurl")
public class DeleteServlet extends HttpServlet {

	private final static String query="delete from user where ID=?";
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	//get printwriter
	PrintWriter pw=res.getWriter();
	//set content type
	res.setContentType("text/html");
	//link the boostrap
	pw.println("<link href='css/bootstrap.css'  rel='stylesheet'></link>");
	// get values
	int ID=Integer.parseInt(req.getParameter("ID"));
	
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
		//set the values
		ps.setInt(1, ID);
		//execute the quries
		int count =ps.executeUpdate() ;
		pw.println("<div class='card' style='margin:auto,width:300px,margin-top:100px>");
		if(count==1) {
			pw.println("<h2 class='bg-danger text-light text-center'>Record is Deleted sucessfully</h2>");
		}else {
			pw.println("<h2 class='bg-danger text-light text-center'>Record is not Deleted </h2>");
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
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
}
