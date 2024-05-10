package Utility;

import employee.Employee;

public class EmpUtils {

	private Employee e;
	private boolean dataready;
	
	public synchronized void writedata(Employee ref) throws Exception{
		System.out.println("write entered --- "+Thread.currentThread().getName());
		while (dataready) {
			this.wait();
		}
		
		e=ref;
		System.out.println("write data -- " + e);
		System.out.println("write exit -- "+Thread.currentThread().getName());
		dataready=true;
		this.notify();
	}
	
	
	public synchronized Employee readdata() throws Exception{
		System.out.println("read entered --"+Thread.currentThread().getName());
		while(!dataready)
			this.wait();
		
		System.out.println("read data -- "+e );
		System.out.println("read exit -- "+Thread.currentThread().getName());
		dataready=false;
		this.notify();
		return e;
	}
	
}
