

	class NewThread implements Runnable{
		String nm;
		Thread t;
		NewThread(String ttt){
			nm = ttt;
			t = new Thread(this, nm);

			System.out.println("new thread"+ t);
			t.start();
		}

		@Override
		public void run() {
			for(int i=1; i<6; i++){
			System.out.println(nm +i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}

			System.out.println(nm +"exiting");
		}
		
	}

public class ThreadTest  {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread f = Thread.currentThread();
		System.out.println("fff"+ f);
		System.out.println("fff"+ f.getPriority());
		
		NewThread tt1 = new NewThread("yk1");
		NewThread tt2 = new NewThread("yk2");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		NewThread tt3 = new NewThread("yk3");

		System.out.println("tt1 isalive"+ tt1.t.isAlive());
		System.out.println("tt2 isalive"+ tt2.t.isAlive());
		System.out.println("tt3 isalive"+ tt3.t.isAlive());
		
		try{

			System.out.println("waiting for threads to finish");
			tt1.t.join();
			//tt2.t.join();
			//tt3.t.join();
			Thread.sleep(1000);
		} catch (InterruptedException e){
			System.out.println("Interrupted");
		}

		System.out.println("tt1 isalive"+ tt1.t.isAlive());
		System.out.println("tt2 isalive"+ tt2.t.isAlive());
		System.out.println("tt3 isalive"+ tt3.t.isAlive());
		
		System.out.println("main thread exit");
		


	}

}
