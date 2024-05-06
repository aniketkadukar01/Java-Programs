package com.app.customer_hashmap;

public enum ServicePlans {
	SILVER(1000),GOLD(2000),DIAMOND(5000),PLATINUM(10000);
	
private double plans;
	
	//constructor 
	ServicePlans(double plans){
		this.plans=plans;
	}
	
	@Override
	public String toString() {
		return name()+" : "+plans;
	}
	
	//getter method of Service Plans
	public double getPlans() {
		return this.plans;
	}
	
}
