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
 * Servlet implementation class EmiCalciRepay
 */
@WebServlet("/EmiCalciRepay")
public class EmiCalciRepay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmiCalciRepay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter printwriter=response.getWriter();
		response.setContentType("text/html");
		DecimalFormat df=new DecimalFormat("0.00");
		HttpSession session=request.getSession();
		EmiCalciEntity emiCalciEntity=(EmiCalciEntity) session.getAttribute("emiobject");
		
		EmiCalciClass emiCalciClass=new EmiCalciClass();
		ArrayList<ArrayList<Double> > aList =  new ArrayList<ArrayList<Double> >();
		
	
		aList=emiCalciClass.repaymentSchedule(emiCalciEntity);
		session.setAttribute("arraylist",aList);
	 
		response.sendRedirect("EmiView1.jsp");
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
