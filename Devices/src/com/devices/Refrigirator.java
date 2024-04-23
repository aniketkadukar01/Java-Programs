
package com.devices;


public class Refrigirator extends Device{
	
	private int capacity;

	public Refrigirator(int id, String brand, int capacity) {
		super(id, brand);
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return super.toString()+" Refrigirator [capacity=" + capacity + "]";
	}

	@Override
	public void on() {
		// TODO Auto-generated method stub
		System.out.println("Refrigerator turning on");
	}

	@Override
	public void off() {
		// TODO Auto-generated method stub
		System.out.println("Refrigerator turning off");
	}
	
	public void freeze() {
		System.out.println("Refrigerator freezing mode on");
	}
	

}
