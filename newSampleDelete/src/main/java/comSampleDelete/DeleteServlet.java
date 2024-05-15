package comSampleDelete;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SubmitFormData")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public DeleteServlet() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mycl = request.getParameter("clientId");
		String myclid = request.getParameter("clientSecret");
		String mygs =  request.getParameter("gstin");
		
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ewayBill", "root", "Aadi@123");
		    
			PreparedStatement ps = con.prepareStatement("insert into testapi values(?,?,?)");
			ps.setString(1, mycl);
			ps.setString(2, myclid);
			ps.setString(3, mygs);
			int count=ps.executeUpdate();
			
			if(count>0)
			{
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.print("<h3 style='color:green;'>User registerd Sucesfully</h3");
		     
				response.sendRedirect("sucess.jsp");
		
			}else {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.print("<h3 style='color:green;'>User registerd Sucesfully</h3");
                RequestDispatcher rd = request.getRequestDispatcher("sucess.jsp");
                rd.include(request, response);
			}
		}catch(Exception e)
		{
			response.setContentType("text/html");
			PrintWriter rd = response.getWriter();
        	rd.print("<h3 style='color:green;'>Exception Occured: "+e.getMessage()+"</h3>");
            System.out.println(rd);
            
            RequestDispatcher rd1 = request.getRequestDispatcher("sucess.jsp");
        	rd1.include(request, response);
            

		}
		
		
	}

}
