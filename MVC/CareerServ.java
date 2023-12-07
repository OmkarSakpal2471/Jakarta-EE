

import jakarta.annotation.Resource;
import mypack.CareerExpert;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

/**
 * Servlet implementation class CareerServ
 */
public class CareerServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * Connection conn;
	 * 
	 * @Resource(lookup="java:/comp/env/mypool") DataSource ds;
	 */
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
/*			conn=ds.getConnection();*/
			String ss=request.getParameter("Qualf");
			CareerExpert ce=new CareerExpert();
			String adv=ce.getAdvice(ss);
			request.setAttribute("so", adv);
			RequestDispatcher rd=request.getRequestDispatcher("CareerDetails.jsp");
			rd.forward(request, response);
			
		
	}

}
