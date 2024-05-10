package runnable;

import Utility.EmpUtils;
import employee.Employee;


public class Producer implements Runnable{
	
	private EmpUtils u;
	private boolean exit;
	
	public Producer(EmpUtils u) {
		this.u=u;
	}
	
	@Override
	public void run() {
		System.out.println("Thread Started "+Thread.currentThread().getName());
		try {
			int i =0;
			while (!exit) {
				u.writedata(new Employee(i,"aa"+i, "HRD", i*100));
				i++;
				Thread.sleep(100);
			}
			
		}catch (Exception e) {
			System.out.println("Error in "+Thread.currentThread().getName());
		}
		System.out.println("Thread over "+Thread.currentThread().getName());
	}
	
	public void stop() {
		exit=true;
	}
	
}
