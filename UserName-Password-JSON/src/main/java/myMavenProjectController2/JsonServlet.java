package myMavenProjectController2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import myMavenProjectcontroller.Sample;

@WebServlet(name = "JsonServlet", urlPatterns = {"/JsonServlet"})
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   PrintWriter out;

  
    public JsonServlet() {
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 out = response.getWriter();
	        try {
	            //getting parameter jsp
	            String jsonData = request.getParameter("para");
	            System.out.println("Print"+jsonData);
                
	            //convert java obj into JSON
	            Gson gson = new Gson();
	            
               //JSON data into a Java object 
	            Sample data = gson.fromJson(jsonData, Sample.class);
	          

	            //calling the getter method
	            System.out.println("Fetching from json object");
	            String name = data.getName();
	            String address = data.getAddress();
	            String city = data.getCity();


	            System.out.println("UserName : " + name);
	            System.out.println("UserAdd : " + address);
	            System.out.println("UserCity : " + city);
	            
	            // create database connection
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/masterpage", "root", "Aadi@123");
	           
				PreparedStatement ps = con.prepareStatement("insert into jsonservlet values(?,?,?)");
				ps.setString(1, name);
				ps.setString(2, address);
				ps.setString(3, city);
				
				int count = ps.executeUpdate();
				if (count>0)
				{
					System.out.println("data inserted sucefully");
					
				}
				else
				{
					System.out.println("failed to insert data");
				}
	         


	            //creating obj to convert it again json
	            Sample user = new Sample();

	            //setting values to object
	            user.setName(name);
	            user.setAddress(address);
	            user.setCity(city);

	            //convert java obj into json & then print JSON string
	            String jsonObj = gson.toJson(user);
	            System.out.println(jsonObj);

	            //sending json response
	            out.print(jsonObj);
	            System.out.println(jsonObj);
	        } catch (JsonSyntaxException e) {
	            out.println(e);
	        } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

	}


