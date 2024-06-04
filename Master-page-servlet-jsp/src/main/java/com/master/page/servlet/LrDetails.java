package com.master.page.servlet;


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

import com.google.gson.Gson;
import com.google.gson.JsonObject;






@WebServlet("/anotherServlet")
public class LrDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public LrDetails() {
        super();

    }


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out = response.getWriter();

	        String mylrno = request.getParameter("lrNo");
	        String myconsigner = request.getParameter("consigner");
	        String myconsignee = request.getParameter("consignee");
	        String myitem = request.getParameter("item");
	        String myamount = request.getParameter("amount");


	        // Construct JSON response
	        Gson gson = new Gson();
	        JsonObject jsonObject = new JsonObject();
	        jsonObject.addProperty("lrno", mylrno);
	        jsonObject.addProperty("consigner", myconsigner);
	        jsonObject.addProperty("consignee", myconsignee);
	        jsonObject.addProperty("item", myitem);
	        jsonObject.addProperty("amount", myamount);

	        String jsonResponse = gson.toJson(jsonObject);

	        // Write JSON response
	        out.print(jsonResponse);
	        out.flush();

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MasterPage", "root","Aadi@123");

	            PreparedStatement ps = con.prepareStatement("insert into secondform values(?,?,?,?,?)");
	            ps.setString(1, mylrno);
	            ps.setString(2, myconsigner);
	            ps.setString(3, myconsignee);
	            ps.setString(4, myitem);
	            ps.setString(5, myamount);


	            int count = ps.executeUpdate();


	            if (count > 0) {




	              	response.setContentType("text/html");
                RequestDispatcher rd = request.getRequestDispatcher("/formSucess.jsp");
	                rd.include(request, response);


	            } else {
	            	response.setContentType("text/html");
	                out.print("<h3 style='color:green;'>User Not registered successfully</h3>");

	                RequestDispatcher rd = request.getRequestDispatcher("/LrDetails.jsp");
	                rd.include(request, response);
	            }
	        }

	        catch (Exception e) {
	            e.printStackTrace();
	            response.setContentType("text/html");
            out.print("<h3 style='color:green;'>Exception Occurred: "+e.getMessage()+"</h3>");

	            RequestDispatcher rd = request.getRequestDispatcher("/LrDetails.jsp");
	            rd.include(request, response);
	        }
	    }
	}


