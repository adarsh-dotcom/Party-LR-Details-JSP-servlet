package comSampleDelete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;



@WebServlet("/SubmitFormData")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public DeleteServlet() {
        super();
       
    }

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
    	String mycl = request.getParameter("clientId");
    	String myclid = request.getParameter("clientSecret");
    	String mygs =  request.getParameter("gstin");
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/masterpage", "root", "Aadi@123");
         
		    
			PreparedStatement ps = con.prepareStatement("insert into testing values(?,?,?)");
			ps.setString(1, mycl);
			ps.setString(2, myclid);
			ps.setString(3, mygs);
			int count=ps.executeUpdate();
			
			if(count>0)
			{
				response.setContentType("text/html");
            	out.print("<h3 style='color:green;'>User registered successfully</h3>");
            	  response.sendRedirect("sucess.jsp");
            	  
            	  
            	  // Now let's make an API call
                  String apiUrl = "https://jsonplaceholder.typicode.com/todos/1"; // replace with your api
                  URL url = new URL("https://jsonplaceholder.typicode.com/todos/1");
                  HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                  conn.setRequestMethod("GET");
                  
                  if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                      // Read the response from the API
                      BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                      String inputLine;
                      StringBuilder responseContent = new StringBuilder();
                      while ((inputLine = in.readLine()) != null) {
                          responseContent.append(inputLine);
                      }
                      in.close();
                      
                      // Parse the JSON response
                      JSONObject jsonResponse = new JSONObject(responseContent.toString());
                      // Example: assuming API response contains a "message" field
                      String apiMessage = jsonResponse.getString("message");
                      out.println("<p>API Message: " + apiMessage + "</p>");
                  } else {
                      out.println("<p>API request failed</p>");
                  }
		
			}else {
				response.setContentType("text/html");
            	out.print("<h3 style='color:green;'>User Not registered successfully</h3>");
            	
            	RequestDispatcher rd = request.getRequestDispatcher("sucess.jsp");
            	rd.include(request, response);
                
			}
		}catch(Exception e)
		{
		 	e.printStackTrace();
        	response.setContentType("text/html");
        	out.print("<h3 style='color:green;'>Exception Occured: "+e.getMessage()+"</h3>");
        	
        	RequestDispatcher rd = request.getRequestDispatcher("sucess.jsp");
        	rd.include(request, response);
                
                
                
                
                
                
                
            

		}
		
		
	}

}
