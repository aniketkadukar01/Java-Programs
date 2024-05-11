package com.app.daoimple;

import java.sql.*;
import static com.app.DBUtils.DBUtils.*;

import com.app.dao.UserDao;
import com.app.entities.user;


public class UserDaoImple implements UserDao{

	private Connection cn;
	private PreparedStatement pst1,pst6,pst7;
	
	public UserDaoImple() throws SQLException {
		cn = openconnection();
		pst1 = cn.prepareStatement("select * from users where email=? and password=?");
		
		pst6 = cn.prepareStatement("delete from users where id=?");
		pst7 = cn.prepareStatement("insert into users values(?,?,?,?,?,?,?,?)");
	}
	
	
	@Override
	public user signIn(String email, String password) throws SQLException {
		pst1.setString(1, email);
		pst1.setString(2, password);
		
		try(ResultSet rst = pst1.executeQuery()){
			if(rst.next())
				return new user (rst.getInt(1), rst.getString(2), rst.getString(3), email, password, rst.getDate(6),
						rst.getBoolean(7), rst.getString(8));
		}
		
		return null;
	}
	
	
	@Override
	public String deleteUser(int id) throws SQLException {
		pst6.setInt(1, id);
		
		int rows = pst6.executeUpdate();
		if(rows == 1)
			return "User deleted";
		
		return "invalid id";
	}


	@Override
	public void insertUser(int userId, String firstName, String lastName, String email, String password, Date dob,
			boolean status, String role) throws SQLException {
		pst7.setInt(1, userId);
		pst7.setString(2, firstName);
		pst7.setString(3, lastName);
		pst7.setString(4, email);
		pst7.setString(5, password);
		pst7.setDate(6, dob);
		pst7.setBoolean(7, status);
		pst7.setString(8, role);
		
		int rows=pst7.executeUpdate();
		if(rows == 1)
			 System.out.println("User entered succussfully");   
		
		else
			System.out.println("invalid inputs");
	}


	public void cleanUp() throws SQLException {
		
		if(pst1 != null)
			pst1.close();
		
		closeConnection();
	}

}
