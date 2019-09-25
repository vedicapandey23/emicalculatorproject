package com.nucleus.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nucleus.model.EmiCalciClass;
import com.nucleus.model.EmiCalciEntity;



/**
 * Servlet implementation class EmiCalciGetRepay
 */
@WebServlet("/EmiCalciGetRepay")
public class EmiCalciGetRepay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmiCalciGetRepay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter printwriter=response.getWriter();
		response.setContentType("text/html");
		 double month=Double.parseDouble(request.getParameter("mname"));
		 HttpSession session=request.getSession();
		 session.setAttribute("month",month);
		DecimalFormat df=new DecimalFormat("0.00");
		
		EmiCalciEntity emiCalciEntity=(EmiCalciEntity) session.getAttribute("emiobject");
		
		EmiCalciClass emiCalciClass=new EmiCalciClass();
		ArrayList<ArrayList<Double> > aList =  new ArrayList<ArrayList<Double> >();
		
		
		printwriter.println("<h2 align=center>Repayment Schedule</h2>");
		
		printwriter.println("<table style=width:100%><tr><th>Outstanding</th><th> Interest</th> <th>Principle</th><th>Emi</th></tr>");
		aList=emiCalciClass.repaymentSchedule(emiCalciEntity);
	
		
		session.setAttribute("arraylist",aList);
		
		response.sendRedirect("EmiView2.jsp");
//		for(int i=0;i<aList.size();i++)
//		{
//			if(i==(month-1))
//					{
//			printwriter.println("<tr></tr>");
//			
//		
//			
//		for(int j=0;j<aList.get(i).size();j++)
//			{                    
//				
//			printwriter.println("<td>"+df.format(aList.get(i).get(j))+"</td>");
//			
//
//			}
//					}
//		
//		
//			
//	
//		}
 

		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
