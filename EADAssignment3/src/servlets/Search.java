package servlets;

import java.io.IOException;
import java.sql.Connection;
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
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String submit = request.getParameter("search");
		String query = "";
		if(submit.equals("Search By Name")){
			
			String column = request.getParameter("column");
			String value = request.getParameter("value");
			query = "select * from student_detail where "+column+"='"+value+"'";
		}else{
			String by_class = request.getParameter("class");
			query = "select * from student_detail where class="+by_class+" order by first_name";
		}
		
		try {  
			Connection conn = new DbConnect().getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			List<Student> list = new ArrayList<Student>();
			while(rs.next()){
				Student student= new Student();
				student.setRoll_no(rs.getInt(1));
				student.setFirst_name(rs.getString(2));
				student.setLast_name(rs.getString(3));
				student.setFather_name(rs.getString(4));
				student.setEmail(rs.getString(5));
				student.setCls(rs.getInt(6));
				student.setAge(rs.getInt(7));
				list.add(student);
			}
			request.setAttribute("student_list", list);
			request.getRequestDispatcher("search.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}