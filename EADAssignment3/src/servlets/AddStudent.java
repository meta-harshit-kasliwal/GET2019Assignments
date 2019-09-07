package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import dao.DbConnect;

@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
        
	int roll_no;
	String first_name;
	String last_name;
	String father_name;
	String email;
	int cls;
	int age;
	String submit;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
			
		roll_no = Integer.parseInt(req.getParameter("roll_no"));
		first_name = req.getParameter("first_name");
		last_name = req.getParameter("last_name");
		father_name = req.getParameter("father_name");
		email = req.getParameter("email");
		cls = Integer.parseInt(req.getParameter("cls"));
		age = Integer.parseInt(req.getParameter("age"));
		submit = req.getParameter("submit");
		PrintWriter out = res.getWriter();
		out.print(roll_no+" "+first_name+" "+last_name+" "+father_name+" "+email+" "+cls+" "+age+" "+submit);
		String query="";
		
		if(submit.equals("Update")){
			query="update student_detail set first_name='"+first_name+"',last_name='"+last_name+"',father_name='"+father_name+"',E_mail='"+email+"',class="+cls+",age="+age+" where roll_no="+roll_no;
		}
		else{
			query = "insert into student_detail values(" + roll_no + ",'" + first_name + "','" + last_name + "','" + father_name + "','" + email + "'," + cls + "," + age + ")";
		}
		int result = addStudent(query);
		if(result>0){
			req.setAttribute("message", "record inserted successfully");
		}
		else{
			req.setAttribute("message", "roll no/email already exist");
		}
		req.getRequestDispatcher("studentaddition.jsp").forward(req,res);
		
		
		}

	public int addStudent(String query) {
		try {
			   Connection conn = new DbConnect().getConnection();
			Statement stmt = conn.createStatement();
			int rs = stmt.executeUpdate(query);
			return rs;
		}
		catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
		
	
		
	}



