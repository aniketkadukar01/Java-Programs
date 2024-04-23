package com.devices;

public class Mobile extends Device {

	private String processor;

	public Mobile(int id, String brand, String processor) {
		super(id, brand);
		this.processor = processor;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	@Override
	public String toString() {
		return super.toString()+" Mobile [processor=" + processor + "]";
	}

	@Override
	public void on() {
		// TODO Auto-generated method stub
		System.out.println("Mobile turning on");
	}

	@Override
	public void off() {
		// TODO Auto-generated method stub
		System.out.println("Mobile turning off");
	}

	public void log() {
		System.out.println("Logging the activities of Mobile Objects");
	}
	
	public void print() {
		System.out.println("Print() in Mobile");
	}
	
	public void runapp() {
		System.out.println("Mobile running apps");
	}
	
	public void monitor() {
		System.out.println("Monitoring the app using abc insights");
	}

	
	
}
