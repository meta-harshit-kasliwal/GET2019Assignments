package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DbConnect;
import model.Student;


/**
 * Servlet implementation class showStudents
 */
@WebServlet("/showStudents")
public class ShowStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */


	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		Statement stmt = null;
		ResultSet res = null;
		Connection conn = null;
		List<Student> studentList = new ArrayList<Student>();
		try{
		    conn =new DbConnect().getConnection();	
			
			stmt = conn.createStatement();
			String query = "select * from student_detail";
			res = stmt.executeQuery(query);
		
			
			while(res.next()) {
				Student student = new Student();
				student.setRoll_no(res.getInt("roll_no"));
				student.setFirst_name(res.getString("first_name"));
				student.setLast_name(res.getString("last_name"));
				student.setFather_name(res.getString("father_name"));
				student.setEmail(res.getString("E_mail"));
				student.setCls(res.getInt("class"));
				student.setAge(res.getInt("Age"));
				studentList.add(student);
			}
		}
		catch(Exception e){
			System.out.println("error while data fetching");
			
		}
			request.setAttribute("StudentList", studentList);
			request.getRequestDispatcher("showStudent.jsp").forward(request,response);
		}
		

	
}