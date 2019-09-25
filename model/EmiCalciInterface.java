package com.nucleus.model;



import java.util.List;



public interface EmiCalciInterface {
	
	public double emiFormula(EmiCalciEntity emiCalciEntity);
	public List repaymentSchedule( EmiCalciEntity emiCalciEntity );
	//public void displayDetails(float outstandingPrinciple[],float interest[], float principle[],float emi);
	//public void getInstallment(EmiCalciEntity emiCalciEntity);
	

}
