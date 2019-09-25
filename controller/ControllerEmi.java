package com.nucleus.controller;



import java.text.DecimalFormat;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nucleus.model.EmiCalciClass;
import com.nucleus.model.EmiCalciEntity;
import com.nucleus.model.EmiCalciInterface;



/**
 * Servlet implementation class ControllerEmi1
 */
@WebServlet("/ControllerEmi")
public class ControllerEmi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerEmi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		DecimalFormat df=new DecimalFormat("0.00");
		
		PrintWriter printwriter=response.getWriter();
		response.setContentType("text/html");
		double loanamount=Double.parseDouble(request.getParameter("loanamount"));
		double rateofinterest=Double.parseDouble(request.getParameter("rateofinterest"));
		double tenure=Double.parseDouble(request.getParameter("tenure"));
		double noofinstallement=Double.parseDouble(request.getParameter("noofinstallment"));
		
		//System.out.println(loanamount);
		
		
		
		EmiCalciEntity emiCalciEntity=new EmiCalciEntity();
		emiCalciEntity.setLoanAmount(loanamount);
		emiCalciEntity.setRateOfInterest(rateofinterest);
		emiCalciEntity.setTenure(tenure);
		emiCalciEntity.setNumberOfInstallmentInAYear(noofinstallement);
		
		
		/*
		System.out.println(emiCalciEntity.getLoanAmount());
		System.out.println(emiCalciEntity.getRateOfInterest());
		System.out.println(emiCalciEntity.getTenure());
		System.out.println(emiCalciEntity.getNumberOfInstallmentInAYear());
		*/
		
		
		EmiCalciInterface emiCalciInterface=new EmiCalciClass();
		double emi=emiCalciInterface.emiFormula(emiCalciEntity);
		String emi2=df.format(emi);
		
		printwriter.println("<table align=center>");
		
		printwriter.println("<tr><td>emi calculated  :"+emi2+"</td></tr>");
		printwriter.println("<tr><td><a href='EmiCalciRepay'>repayment schedule</a>");
		printwriter.println("<tr><td><form action=EmiCalciGetRepay>get repayment schedule of the month</a>");
		printwriter.println("<tr><td>enter the month</td></tr>");
		printwriter.println("<tr><td><input type=text name=mname></input></td></tr>");
		printwriter.println("<tr><td><input type=submit></input></td></tr>");
		
		
		
		HttpSession session=request.getSession();
		
		session.setAttribute("emiobject",emiCalciEntity);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
