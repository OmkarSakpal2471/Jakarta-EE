

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

/**
 * Servlet implementation class StudentServ
 */
public class StudentServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;

	
	@Override
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String ss = "jdbc:mysql://localhost:3306/bit";
			con = DriverManager.getConnection(ss, "root", "Omkar123");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			PrintWriter out=response.getWriter();
			int rollnum=Integer.parseInt(request.getParameter("rollno"));
			String name=request.getParameter("name");
			int age=Integer.parseInt(request.getParameter("age"));
			String address=request.getParameter("address");
			
			PreparedStatement pst=con.prepareStatement("Insert into Student11 values(?,?,?,?)");
			pst.setInt(1, rollnum);
			pst.setString(2, name);
			pst.setInt(3, age);
			pst.setString(4, address);
			
			int rows=pst.executeUpdate();
			if(rows>0) {
				out.println("Records added");
			}else {
				out.println("No Records added");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out=response.getWriter();
		try {
			PreparedStatement pst=con.prepareStatement("Select rollno from Student11");
			ResultSet rs=pst.executeQuery();
			List<Integer> myList=new ArrayList<Integer>();
			while(rs.next()) {
				myList.add(rs.getInt(1));
			}
			request.setAttribute("ArrayList", myList);
			RequestDispatcher rd=request.getRequestDispatcher("Report.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	} 
	
	

}
