package testjdbc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class TestDb
 */
@WebServlet("/TestDb")
public class TestDb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//setup connection variables
		String user = "springstudent";
		String pass = "springstudent";
		
		String jbdcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";
		
		//get connection to database
		try{
			PrintWriter out = response.getWriter();
			
			out.println("Connectin to databse: " + jbdcUrl);
			
			Class.forName(driver);
			
			Connection myConn = DriverManager.getConnection(jbdcUrl, user, pass);
			
			out.println(" ");
			out.println("Connection succesful!");
			
			myConn.close();
			
		}
		catch (Exception exc){
			exc.printStackTrace();
			throw new ServletException(exc);
		}
		
		
		
		
		
	}

}
