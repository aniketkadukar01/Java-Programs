package com.app.tester;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

import com.app.daoimple.UserDaoImple;
import com.app.entities.user;

public class tester {

	public static void main(String[] args) throws SQLException {
		try(Scanner sc =new Scanner(System.in)){
			UserDaoImple userDao=new UserDaoImple();
			boolean exit = false;
			while (!exit) {
				System.out.println("Options \n1: Login \n" + "2: Display user details by DoB\n"
						+ "3: Voter registration \n"+"4: change password\n" +"5: transfar funds\n"
						+ "6: delete user\n"+"7: add user\n"+"0: Exit");
				try {
					switch(sc.nextInt()) {
					
					case 1:
						System.out.println("Enter your email and password");
						user user = userDao.signIn(sc.next(), sc.next());
						if(user != null) {
							System.out.println("Login sucessfully");
							System.out.println(user);
						}
						else
							System.out.println("Invalid email or password!!!!");
						break;
						
					case 6:
						System.out.println("Enter user id");
						System.out.println(userDao.deleteUser(sc.nextInt()));
						break;
						
					case 7:
						System.out.println("userId, firstName, lastName, email, password, dob, status,\r\n"
								+ " role");
						userDao.insertUser(sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.next()
								, Date.valueOf(sc.next()), false, "voter");
						break;
					
					case 0:
						exit=true;
						userDao.cleanUp();
						break;
					
					}
					
				}catch(Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
