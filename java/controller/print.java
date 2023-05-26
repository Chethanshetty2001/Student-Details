package controller;

import java.io.IOException;
import java.util.Arrays;
import java.sql.*;
import javax.security.auth.message.callback.SecretKeyCallback.Request;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import dao.studentdao;
import dto.student;

@WebServlet("/print")
public class print extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		student std = new student();
		std.setGender( req.getParameter("gender"));
//		std.setId(id);
		std.setTotal_Marks(Long.parseLong(req.getParameter("total")));
		std.setName(req.getParameter("name"));
		
		studentdao std2 = new studentdao();
		std2.save(std);
		
	}
}
