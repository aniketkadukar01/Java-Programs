package com.devices;

public abstract class Device {
	
	private int id;
	private String brand;
	
	public Device(int id, String brand) {
		this.id = id;
		this.brand = brand;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	@Override
	public String toString() {
		return "Device [id=" + id + ", brand=" + brand + "]";
	}
	
	public abstract void on();
	public abstract void off();
	
}
