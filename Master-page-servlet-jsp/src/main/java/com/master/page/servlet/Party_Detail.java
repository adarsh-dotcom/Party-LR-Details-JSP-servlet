package com.master.page.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/anotherServlett")
public class Party_Detail  extends HttpServlet{
	
	
	
	    private static final long serialVersionUID = 1L;
	

	    public Party_Detail() {
	        super();
	    } 

	 
	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        PrintWriter out = response.getWriter();

	        String myPartyCode = request.getParameter("Party_code");
	        String mypartyName = request.getParameter("Party_Name");
	        String myaddress = request.getParameter("Address");
	        String myGSTn = request.getParameter("GsTn");
	        String myState = request.getParameter("State");
	        String mypincode = request.getParameter("Pincode");
	       
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MasterPage", "root","Aadi@123");

	            PreparedStatement ps = con.prepareStatement("insert into fisrstform values(?,?,?,?,?,?)");
	            ps.setString(1, myPartyCode);
	            ps.setString(2, mypartyName);
	            ps.setString(3, myaddress);
	            ps.setString(4, myGSTn);
	            ps.setString(5, myState);
	            ps.setString(6, mypincode);
	            int count = ps.executeUpdate();
	            
	            if (count > 0) {
	            	response.setContentType("text/html");
	            	out.print("<h3 style='color:green;'>User registered successfully</h3>");
	            	  response.sendRedirect("anotherServlet.jsp");
	            	
	            	//Fetching Data into the database
	            	PreparedStatement fetchStatement  = con.prepareStatement("SELECT Party_code FROM fisrstform");
	            	ResultSet resultSet = fetchStatement.executeQuery();
	            	
	            	List<String> partycode = new ArrayList<>();
	            	//fetching data from the resultSets
	            	while(resultSet.next()) {
	            		partycode.add(resultSet.getString("Party_code"));
	            	}
	            	request.setAttribute("partyCodes", partycode);
	            	RequestDispatcher dispatcher = request.getRequestDispatcher("anotherServlet.jsp?consigner=dropdown&consignee=dropdown");
	            	dispatcher.forward(request, response);
	            	
	            	
	            	
	            } else {
	            	response.setContentType("text/html");
	            	out.print("<h3 style='color:green;'>User Not registered successfully</h3>");
	            	
	            	RequestDispatcher rd = request.getRequestDispatcher("anotherServlet.jsp");
	            	rd.include(request, response);
	            }
	        }
	        
	        catch (Exception e) {
	        	e.printStackTrace();
	        	response.setContentType("text/html");
	        	out.print("<h3 style='color:green;'>Exception Occured: "+e.getMessage()+"</h3>");
	        	
	        	RequestDispatcher rd = request.getRequestDispatcher("partyDetails.jsp");
	        	rd.include(request, response);
	        }
	        
	        
	        
	        
	    }
}
	           
	            
	        
	            

	            
	            
	            
	            
	            
	              
	                
	                	
	                	
	                
	                
	              
	                
	                
	                
	                
	    	    
	          
				    
				

	            
	    
	


