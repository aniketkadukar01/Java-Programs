package runnable;

import Utility.EmpUtils;

public class Consumer implements Runnable {
	private EmpUtils u;
	private boolean exit;
	
	public Consumer(EmpUtils u) {
		this.u=u;
	}
	
	@Override 
	public void run() {
		System.out.println("Thread started" + Thread.currentThread().getName());
		try {
			while (!exit) {
				u.readdata();
				Thread.sleep(400);
			}
		}catch (Exception e) {
			System.out.println("Error in "+Thread.currentThread().getName()+" "+e);
		}
		System.out.println("Thread over "+Thread.currentThread().getName());
	}
	
	public void stop() {
		exit=true;
	}
	
}
