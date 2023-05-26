package controller;

import java.beans.Statement;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import org.apache.catalina.Manager;

import dao.studentdao;
import dto.student;



@WebServlet("/fetchAll")
public class fetchdetails extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.getWriter().print("<html><body>"
				+"<table border='1'>"
				+"<tr>"
				+"<th>ID</th>"
				+"<th>Name</th>"
				+"<th>Total_Marks</th>"
				+"<th>Gender</th>"
				+"</tr>"
				);
		
	
	studentdao dao = new studentdao();
	List<student> list = dao.fetchAll();
	
	for(student std : list){
		res.getWriter().print("<tr>"
				+"<th>"+std.getId()+"</th>"
				+"<th>"+std.getName()+"</th>"
				+"<th>"+std.getTotal_Marks()+"</th>"
				+"<th>"+std.getGender()+"</th>"
				+"</tr>"
				);
	}
	res.getWriter().print("</table>"
	+"</body></html>");
	

}
}

