package lnew;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
public class login {
	private static Connection con;	
	String url="jdbc:mysql://localhost:3306/library";
	String user="root";
	String pass="";	
	public login() {
	try {
	con=DriverManager.getConnection(url,user,pass);	
	}
	catch(Exception e) {	e.printStackTrace();}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Press 1 for User and  2 for Admin  ");
		int n=sc.nextInt();		
		if(n==1) {		
			System.out.println("Press 1 for Already registered  User. \nPress 2 for New User");
			int u=sc.nextInt();
			
			if (u==1) {
		System.out.println("Press 1 for your detail \n2 for book details");
				int a=sc.nextInt();
				    if(a==1) {
					mainclass cud=new mainclass();
					cud.user();				
					}
					else if(a==2) {
						mainclass bo=new mainclass();
						bo.user_Book_Details();
					}
				}
		     else if(u==2) {  
				mainclass nu=new mainclass();
				nu.newuser();     }
		}
		else if(n==2) {
			System.out.print("Enter Your ID : ");
			int id=sc.nextInt();
			System.out.print("Enter Your Password : ");
			String pass=sc.next();
			try {
				String url="jdbc:mysql://localhost:3306/library";
				String user="root";
				String pass1="";
				con=DriverManager.getConnection(url,user,pass1);	
			String q="select *from admin where id=? and password=?";
			PreparedStatement pst=con.prepareStatement(q);
			pst.setInt(1, id);
			pst.setString(2, pass);
			ResultSet rs=pst.executeQuery();
			boolean r=false;
			while(rs.next()) {
				r= true;}
			if(r==true) {
				System.out.println("Press 1 for User_Details and 2 for Book_Details");
				int ch=sc.nextInt();
				
				if(ch==1) {
					mainclass c=new mainclass();
					c.Menu();
				}
				
				if(ch==2) {
					mainclass c=new mainclass();
					c.Book_Details();}
				else {
					System.out.println("Invalid Login");
					
				}
					
			}else {
				System.out.println("Invalid Login");
			}
			
			}
			catch(Exception e) {
				System.out.println(e);
			}sc.close();
	}
 }   
}
	
		
	
	

