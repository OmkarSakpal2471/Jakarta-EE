

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class SecondServ
 */
public class SecondServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] myL=request.getParameterValues("proname");
		List<String> li=new ArrayList<String>();
		for (String string : myL) {
			li.add(string);
		}
		HttpSession session=request.getSession();
		session.setAttribute("mySess", li);
		RequestDispatcher rd=request.getRequestDispatcher("Bill.jsp");
		rd.forward(request, response);
		
		
	}

}
