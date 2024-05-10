package tester;

import Utility.EmpUtils;
import runnable.Consumer;
import runnable.Producer;

public class Tester {

	public static void main(String[] args) throws Exception{
		EmpUtils u = new EmpUtils();
		String[] nms = {"producer","consumer"};
		
		Producer p1 =new Producer(u);
		Thread t1 = new Thread(p1,nms[0]);
		t1.start();
		Thread.sleep(10);
		
		Consumer c1 = new Consumer(u);
		Thread t2 =new Thread(c1,nms[1]);
		t2.start();
		
		System.out.println("press enter to exit ");
		System.in.read();
		p1.stop();
		c1.stop();
		
		Thread.sleep(10);
		
		if(t1.isAlive())
			t1.interrupt();
		
		if(t2.isAlive())
			t2.interrupt();
		
		t1.join();
		t2.join();
		
		System.out.println("Main over");
	}

}
