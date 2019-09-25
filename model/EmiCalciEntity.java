package com.nucleus.model;


public class EmiCalciEntity {

@Override
	public String toString() {
		return "loanAmount=" + loanAmount + ", rateOfInterest=" + rateOfInterest + ", tenure=" + tenure
				+ ", numberOfInstallmentInAYear=" + numberOfInstallmentInAYear + "]";
	}
private	double loanAmount;
private	double rateOfInterest;
private	double tenure;
private	double numberOfInstallmentInAYear;

public double getLoanAmount() {
	return loanAmount;
}
public void setLoanAmount(double loanAmount) {
	this.loanAmount = loanAmount;
}
public double getRateOfInterest() {
	return rateOfInterest;
}
public void setRateOfInterest(double rateOfInterest) {
	this.rateOfInterest = rateOfInterest;
}
public double getTenure() {
	return tenure;
}
public void setTenure(double tenure) {
	this.tenure = tenure;
}
public double getNumberOfInstallmentInAYear() {
	return numberOfInstallmentInAYear;
}
public void setNumberOfInstallmentInAYear(double numberOfInstallmentInAYear) {
	this.numberOfInstallmentInAYear = numberOfInstallmentInAYear;
}










}
