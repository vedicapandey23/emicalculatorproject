package com.nucleus.model;


import java.text.*;
import java.util.ArrayList;
import java.util.List;



public class EmiCalciClass implements EmiCalciInterface {

	//EmiCalciEntity emiCalciEntity=new EmiCalciEntity();
	
	
	public double emiFormula(EmiCalciEntity emiCalciEntity) {
		double a,b,c,d,e;
		
		
		e=emiCalciEntity.getRateOfInterest()/100;
		
		
		a=emiCalciEntity.getLoanAmount()*(e/emiCalciEntity.getTenure());
		c=(1+(e/emiCalciEntity.getTenure()));
		d=Math.pow(c,emiCalciEntity.getNumberOfInstallmentInAYear());
		b=(1-(1/d));
		double x=(a/b);
       
		DecimalFormat df=new DecimalFormat("0.00");
		
		
		
        return x;
		
	}

	/*public double outstandingprinciple(){
		
	}*/
	public ArrayList repaymentSchedule(EmiCalciEntity emiCalciEntity) {
		double outstandingPrinciple[]=new double[(int) (emiCalciEntity.getNumberOfInstallmentInAYear()+1)];
		double interest[]=new double[(int) (emiCalciEntity.getNumberOfInstallmentInAYear()+1)];
		double principle[]=new double[(int) (emiCalciEntity.getNumberOfInstallmentInAYear()+1)];
		DecimalFormat df=new DecimalFormat("0.00");
		 ArrayList<ArrayList<Double> > aList =  new ArrayList<ArrayList<Double> >(); 
		
		
		ArrayList<Double> list1=new ArrayList<>();
		
		outstandingPrinciple[0]=emiCalciEntity.getLoanAmount();
		list1.add(outstandingPrinciple[0]);
		
	double emi=emiFormula(emiCalciEntity);
		
		for(int i=0;i<emiCalciEntity.getNumberOfInstallmentInAYear();i++)
		{
			if(i==0)
			{
				interest[i]=(outstandingPrinciple[i]*((emiCalciEntity.getRateOfInterest()/100)))/12;
				list1.add(interest[i]);
				principle[i]=emi-interest[i];
				list1.add(principle[i]);
				list1.add(emi);
				aList.add(list1);
				if(i!=emiCalciEntity.getNumberOfInstallmentInAYear())
				{
					outstandingPrinciple[i+1]=outstandingPrinciple[i]-principle[i];
					//list2.add(outstandingPrinciple[i+1]);
					
				}
			}
			else
			{
				
			ArrayList<Double> list2=new ArrayList<>();
			list2.add(outstandingPrinciple[i]);
			interest[i]=(outstandingPrinciple[i]*((emiCalciEntity.getRateOfInterest()/100)))/12;
			list2.add(interest[i]);
			principle[i]=emi-interest[i];
			list2.add(principle[i]);
			list2.add(emi);
			aList.add(list2);
			//list1.clear();
			if(i!=emiCalciEntity.getNumberOfInstallmentInAYear())
			{
				outstandingPrinciple[i+1]=outstandingPrinciple[i]-principle[i];
				//list2.add(outstandingPrinciple[i+1]);
				
			}
			}
	    }
		return aList ;
		
	}

	
	
}


