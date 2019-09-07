package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import dao.DbConnect;

/**
 * Servlet implementation class UpdateRecord
 */
@WebServlet("/UpdateRecord")
public class UpdateRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateRecord() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("roll_no"));
		try{
		 Connection conn = new DbConnect().getConnection();
		 Statement stmt = conn.createStatement();
		String query = "select * from student_detail where roll_no="+id;
		Student student = new Student();
		
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()){
				student.setRoll_no(rs.getInt(1));
				student.setFirst_name(rs.getString(2));
				student.setLast_name( rs.getString(3));
				student.setFather_name(rs.getString(4));
				student.setEmail(rs.getString(5));
				student.setCls(rs.getInt(6));
				student.setAge(rs.getInt(7));
				request.setAttribute("update_student", student);
				request.getRequestDispatcher("updatestudent.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}