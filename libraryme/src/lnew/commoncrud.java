package lnew;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class commoncrud {
	private Connection con;	
	String url="jdbc:mysql://localhost:3306/library";
	String user="root";
	String pass="";
	
	
	public commoncrud() {
	try {
	con=DriverManager.getConnection(url,user,pass);	
	}
	catch(Exception e) 
	{	e.printStackTrace(); }
	}
	//select the user details by administrator
	public void selecta(){ 
		try {
		String q="select * from user";
		PreparedStatement pst=con.prepareStatement(q);
		ResultSet rs=pst.executeQuery();
		while(rs.next()) {
			int ID=rs.getInt("ID");
			String FName=rs.getString("FName");
			String LName=rs.getString("LName");
			int Age=rs.getInt("Age");
			long AadharNo=rs.getLong("AadharNo");
			long PhoneNo=rs.getLong("PhoneNo");		
	System.out.print("User ID: "+ID+"\nUser Name: "+FName+LName+"\nAge: "+Age+"\nAadhar No: "+AadharNo+"\nPhone No: "+PhoneNo+"\n\n");
	}		
	  }catch(Exception e) {	e.printStackTrace(); }	
}
	//here the new user details are inserted into the table
	public int insert(String FName,String LName,int Age,long AadharNo,long PhoneNo,String UserName,String Password) {
	int r=0;
	try {
	String q="insert into user( FName,LName,Age,AadharNo,PhoneNo,UserName,Password) values(?,?,?,?,?,?,?)";
	PreparedStatement pst=con.prepareStatement(q);
	pst.setString(1, FName);
	pst.setString(2, LName);
	pst.setInt(3,Age);
	pst.setLong(4,AadharNo);
	pst.setLong(5, PhoneNo);
	pst.setString(6, UserName);
	pst.setString(7, Password);
	r=pst.executeUpdate();
	}catch(Exception e) {	e.printStackTrace(); }	
	return r;
	}
	// here the details of user seen by give the right user name and password
	public int select(String UserName,String Password) {
		int r=0;
	try {
	String q="select *from user where UserName=? and password=?";
	PreparedStatement pst=con.prepareStatement(q);
	pst.setString(1, UserName);
	pst.setString(2, Password);
	ResultSet rs=pst.executeQuery();
	while(rs.next()) {
		int ID=rs.getInt("ID");
		String FName=rs.getString("FName");
		String LName=rs.getString("LName");
		int Age=rs.getInt("Age");
		long AadharNo=rs.getLong("AadharNo");
		long PhoneNo=rs.getLong("PhoneNo");
System.out.print("Your ID: "+ID+"\nName: "+FName+LName+"\nAge: "+Age+"\nAadhar No: "+AadharNo+"\nPhone No: "+PhoneNo+"\n\n");
	}		
	}catch(Exception e) {	e.printStackTrace(); }	
	return r;}
	
// here the user details are updated by user 
	public int update(String FName,String LName,long PhoneNo,String UserName,String Password) {
		int r=0;
		try {
		String q="update user set FName=? LName=? PhoneNo=?  where UserName=? and Password=?"; 
		PreparedStatement pst=con.prepareStatement(q);
		pst.setString(1,FName);
		pst.setString(2,LName);
		pst.setLong(3,PhoneNo);
		pst.setString(4, UserName);
		pst.setString(5, Password);
		r=pst.executeUpdate();
		}catch(Exception e) {	e.printStackTrace(); }
			return r;} 
	
	// here the code for delete the user details form the table
	public int delete(int ID) {
		int r=0;
		try
		{		
		String q="delete from user where ID=?";
		PreparedStatement pst=con.prepareStatement(q);
		pst.setInt(1, ID);	
		r=pst.executeUpdate();	
		}
		catch(Exception e) {	e.printStackTrace();	}
			return r;}
	
	//here the book details are view by searching of book name
	public int selectbook(String bookname) {
		int r=0;
	try {
	String q="select *from book where bookname=?";
	PreparedStatement pst=con.prepareStatement(q);
	pst.setString(1,bookname);
	ResultSet rs=pst.executeQuery();
	while(rs.next()) {
		String booksname=rs.getString("bookname");
		String booksauthor=rs.getString("bookauthor");
		long bookcode=rs.getLong("book_code");
		int rack=rs.getInt("rack_no");
		int shelf=rs.getInt("shelf_no");
System.out.print("Book Name: "+booksname+"\nAuthor Name: "+booksauthor+"\nBook code: "+bookcode+"\nRack Number: "+rack+"\nShelf Number: "+shelf+"\n\n");
	}		
	}catch(Exception e) {	e.printStackTrace(); }	
	return r;}
	
//here the new books are add by the administrator
public int insertb(String bookname,String bookauthor,long code,int quantity,int rack,int shelf ) {
		int r=0;
try {
	String q="insert into book( bookname, bookauthor, book_code, quantity, rack_no, shelf_no) values(?,?,?,?,?,?)";
		PreparedStatement pst=con.prepareStatement(q);
		pst.setString(1, bookname);
		pst.setString(2, bookauthor);
		pst.setLong(3,code);
		pst.setInt(4,quantity);
		pst.setInt(5, rack);
		pst.setInt(6, shelf);
		r=pst.executeUpdate();	
		}catch(Exception e) {	e.printStackTrace(); }			
		return r;}

		//here the book details are view by administrator
		public  void selectb() {
		try {
		String q="select *from book";
		PreparedStatement pst=con.prepareStatement(q);
		ResultSet rs=pst.executeQuery();
		while(rs.next()) {
			int sno=rs.getInt("S_No");
			String bookname=rs.getString("bookname");
			String bookauthor=rs.getString("bookauthor");
			long code=rs.getLong("book_code");
			int quantity=rs.getInt("quantity");
			int rack=rs.getInt("rack_no");
			int shelf=rs.getInt("shelf_no");	
	System.out.print("Serial Number: "+sno+"\nBook Name: "+bookname+"\nAuthor Namae: "+bookauthor+"\nBook code: "+code+"\n Book Quantity: "+quantity+"\nRack number: "+rack+"\nShelf Number: "+shelf+"\n\n");
		}		
		}catch(Exception e) {	e.printStackTrace(); }	
		}
       //here the book details are updated code
		public int updateb(int quantity,int rack,int shelf,String bookname) {
			int r=0;
			try {
			String q="update book set quantity=? rack_no=? shelf_no=? where bookname=?"; 
			PreparedStatement pst=con.prepareStatement(q);
			pst.setInt(1,quantity);
			pst.setInt(3,rack);
			pst.setInt(4,shelf);
			pst.setString(5, bookname);
	        
			r=pst.executeUpdate();
			
			}catch(Exception e) {	e.printStackTrace(); }
				return r;}
		
		// here the book details deletion code
		public int deleteb(long book_code) {
			int r=0;
			try
			{
			String q="delete from book where book_code=?";
			PreparedStatement pst=con.prepareStatement(q);
			pst.setLong(1, book_code);	
			r=pst.executeUpdate();	
			}
			catch(Exception e) 	{e.printStackTrace();}
				return r;}	
}



