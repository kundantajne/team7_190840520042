package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DBUtil.DBConnection;
import com.pojo.User;

/**
 * Servlet implementation class regServlet
 */
@WebServlet("/reg")
public class regServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public regServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("uname");
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		
		User user=new User();
		user.setUname(uname);
		user.setEmail(email);
		user.setPass(pass);
		
		try (PrintWriter out=response.getWriter();
		){
			Connection connection=DBConnection.getConnection();
			System.out.println("COnnection Successful.......");
			Statement stmt=connection.createStatement();
			ResultSet rs=stmt.executeQuery("select * from reguser");
			
			if(rs.next()){
				if(email.equals(rs.getString("email"))) {
					//System.out.println("Email alredy exits!!!!!");
					out.print("Email Already Exits!!!!!!!!!!");
					
				}
				else {
					
					int i=stmt.executeUpdate("insert into reguser values('"+user.getUname()+"','"+user.getEmail()+"','"+user.getPass()+"')");
					if(i>0) {
						out.print("<html>");
						out.print("<title>");
						out.print("Registration PAge");
						out.print("</title>");
						out.print("<body>");
						out.print("Registration Successful yo");
						out.print("</body>");  
						out.print("</html>");
					}
				}
				
			}
			else {
				
				int i=stmt.executeUpdate("insert into reguser values('"+uname+"','"+email+"','"+pass+"')");
				if(i>0) {
					out.print("<html>");
					out.print("<title>");
					out.print("Registration PAge");
					out.print("</title>");
					out.print("<body>");
					out.print("Registration Successful");
					out.print("</body>");  
					out.print("</html>");
			}
			
			
			}
			
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
		doGet(request, response);
	}

}
