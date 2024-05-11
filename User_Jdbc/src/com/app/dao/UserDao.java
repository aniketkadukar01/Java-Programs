package com.app.dao;

import java.sql.Date;
import java.sql.SQLException;

import com.app.entities.user;

public interface UserDao {

	user signIn(String email,String password) throws SQLException;
	
	String deleteUser(int id) throws SQLException;

	void insertUser(int userId,String firstName,String lastName,String email,String password
			,Date dob,boolean status,String role) throws SQLException;
	
}

