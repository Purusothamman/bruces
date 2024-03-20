package lnew;
import java.util.Scanner;
public class mainclass {

   public void Menu() {
	   commoncrud cd=new commoncrud();
	        System.out.println("Library Management Portal\nWelcome Admin ");
			Scanner sc=new Scanner(System.in);
			while(true) {
			System.out.println("User Details for Admin:");
			System.out.println("1.View all Users\n2.Remove the User\n3.Insert a new User\n4.Exit");
			System.out.print("Enter the Choice : ");
			int ch=sc.nextInt();
			sc.nextLine();
			if(ch==3){
				//insert
			System.out.print("Welcome - Have a Nice Day...\nInsert the New user to our portal.\n");
			System.out.print("Enter the First Name: ");	
			String FName=sc.next();
			System.out.print("Enter the Last Name: ");
			String LName=sc.next();
			System.out.print("Enter the Age: ");
			int Age =sc.nextInt();
			System.out.print("Enter the Aadhar Number: ");
			long AadharNo=sc.nextLong();
			System.out.print("Enter the Phone Number: ");
			long PhoneNo=sc.nextLong();
			System.out.print("Create a UserName: ");	
			String UserName=sc.next();
			System.out.print("Create a Password: ");	
			String Password=sc.next();
			
			int res=cd.insert( FName, LName, Age, AadharNo, PhoneNo, UserName, Password);
			System.out.println((res>0)?"Successfully Registered":"Not Registered");
			
			}
			else if(ch==1){
				//select 
				cd.selecta();
				System.out.println("\nEnd of the Records");
			}
			else if(ch==2){
				//Delete
				System.out.print("ID : ");
				int id=sc.nextInt();
				int res=cd.delete(id);
				System.out.println((res>0)?"Deleted":"Not Deleted");
			}
			else if(ch==4) {
				System.out.println("Process Aborted !!! - Thankyou for Visiting...");
				break;
				
			}
			else{
				System.out.println("Invalid Choice Please check it !");
			}
			}
			sc.close();
		}
		
		
	public void Book_Details() {
		   commoncrud cd1=new commoncrud();
				
				System.out.println("Library Management Portal\nWelcome Admin");
				Scanner sc=new Scanner(System.in);
				while(true) {
				System.out.println("Book Details for you:");
				System.out.println("1. Add a new Book \n2. View All books\n3. Edit from the collections \n4. Remove the Book \n5. Exit");
				System.out.print("Enter the Choice : ");
				int ch=sc.nextInt();
				sc.nextLine();
				if(ch==1){
					//insert
				System.out.println("Hi I'm execting to see whats the new collection...\n");
				System.out.println("Enter the Book Name: ");	
				String bookname=sc.next();
				System.out.println("Enter the Author Name: ");
				String bookauthor=sc.next();
				System.out.println("Enter the Book code: ");
				long code =sc.nextLong();
				System.out.println("Enter the the Number Books in Stock: ");
				int quantity=sc.nextInt();
				System.out.println("Enter the rack number for this book: ");	
				int rack=sc.nextInt();
				System.out.println("Enter the Shelf number for this book: ");	
				int shelf=sc.nextInt();
				
				int res=cd1.insertb( bookname, bookauthor, code, quantity, rack, shelf);
				System.out.println((res>0)?"Successfully Registered":"Not Registered");
				
				}
				else if(ch==2){
					//select 
					cd1.selectb();
					System.out.println("End of the Records");
				}
				else if(ch==3){
					//update
					System.out.println("Hi You want to update the  book details...\n");
					System.out.println("Enter the book Name: ");
					String bookname=sc.next();
					System.out.print("Current Quantity of the book: ");
					int quantity=sc.nextInt();
					System.out.print("Currently the Book at which rack: ");
					int rack=sc.nextInt();
					System.out.print("Currently the Book at which shelf: ");
					int shelf=sc.nextInt();
					int res=cd1.updateb(quantity,rack,shelf,bookname);
					System.out.println((res>0)?"Successfully Updated":"Not Updated");
				}
				else if(ch==4){
					//Delete
					System.out.print("Enter the Book Code for delete the record: ");
					long book_code=sc.nextLong();
					int res=cd1.deleteb(book_code);
					System.out.println((res>0)?"Successfully Deleted":"Not Deleted");
				}
				else if(ch==5) {
					System.out.println("thank you!!!");
					break;}
				else if(ch==0) {
					System.out.println("Process Aborted!!!");
					break;
					
				}
				else{
					System.out.println("Invalid Choice");
				}
				}
				sc.close();
			}
public void newuser() {
	   commoncrud nuc=new commoncrud();
		Scanner sc=new Scanner(System.in);
System.out.println("Welcome to the library portal..\nThankyou for join with as give your details  here..\n");
	    System.out.print("Enter the First Name: ");	
		String FName=sc.next();
		System.out.print("Enter the Last Name: ");
		String LName=sc.next();
		System.out.print("Enter the Age: ");
		int Age =sc.nextInt();
		System.out.print("Enter the Aadhar Number: ");
		long AadharNo=sc.nextLong();
		System.out.print("Enter the Phone Number: ");
		long PhoneNo=sc.nextLong();
		System.out.print("Create a UserName: ");	
		String UserName=sc.next();
		System.out.print("Create a Password: ");	
		String Password=sc.next();
		sc.close();
		int res=nuc.insert( FName, LName, Age, AadharNo, PhoneNo, UserName, Password);
		System.out.println((res>0)?"Successfully Registered":"Not Registered");
    }
 public void user() {
			   commoncrud cd=new commoncrud();
					System.out.println("Welcome to the Library Management Portal");
					Scanner sc=new Scanner(System.in);
					while(true) {
					System.out.println("See Your Details :");
					System.out.println("1.Edit\n2.Remove\n3.View\n4.Exit\n");
					System.out.println("Enter the Choice : ");
					int ch=sc.nextInt();
					sc.nextLine();
					  if(ch==1){
						//update
						System.out.print("Enter the User Name: ");
						String UserName=sc.next();
						System.out.print("Change the Password: ");
						String Password=sc.next();
						System.out.print("Rename the Frist Name: ");
						String FName=sc.next();
						System.out.print("Rename the Last Name: ");
						String LName=sc.next();
						System.out.print("Update the Phone Number: ");
						long PhoneNo=sc.nextLong();
						
						
						int res=cd.update( FName,LName, PhoneNo,UserName,Password);
						System.out.println((res>0)?"Successfully Updated":"Not Updated");
					}
					  else if(ch==3){
							//view
							System.out.print("Enter the UserName : ");
							String UserName=sc.next();
							System.out.print("Enter the Password : ");
							String Password=sc.next();
							int res=cd.select(UserName, Password);		
						System.out.println((res>0)?"This is your data":"Enter the valid username and password");

					  }
					else if(ch==2){
						//Delete
						System.out.print("ID : ");
						int id=sc.nextInt();
						int res=cd.delete(id);
						System.out.println((res>0)?"Successfully Deleted":"Not Deleted");
					}
					else if(ch==4) {
						System.out.println("Process Aborted!!!");
	                    break;
					}
					else{
						System.out.println("Invalid Choice");
					}
					}sc.close();
				}
 
public void user_Book_Details() {
		   commoncrud cd3=new commoncrud();
				
				System.out.println("Welcome to the Library Management Portal");
				Scanner sc=new Scanner(System.in);
				
				while(true) {
				System.out.println("Book Details for User:");
				System.out.println("1.View All books\n2.Search by BookName\n3.Exit");
				System.out.print("Enter the Choice : ");
				int ch=sc.nextInt();
				//sc.nextLine();
				 if(ch==1){
					//select 
					cd3.selectb();
					System.out.println("End of the Records");
				 }
				 else if(ch==2) {
					 System.out.print("Enter the BookName : ");
						String bookname=sc.next();
						int res=cd3.selectbook(bookname);		
					System.out.println((res>0)?"this is book data":"Enter the book is not available");
				 }
				 else if(ch==3) {
						System.out.println("thankyou for visiting");
						break;
					          }
				 sc.close();
				 }					
		}				
}
