class Bike{
	public boolean flag=false;
	
	synchronized public void useBike(){
		System.out.println(Thread.currentThread().getName()+": Using Bike");
		if(flag){
			try{	
				wait();
				//Thread.sleep(1000);
			}catch(Exception e){}
		}
		flag=true;
		finshUise();
		//notify();
	}
	
	synchronized public void finshUise(){
		flag=false;
		try{
			Thread.sleep(1000);
		}catch(Exception e){}
		System.out.println(Thread.currentThread().getName()+": Finished");
		notify();
	}
}

class Rahim implements Runnable{
	Bike b;
	Rahim(Bike b){
		this.b=b;
		new Thread(this,"Rahim").start();
	}
	public void run(){
		System.out.println("Rahim wants to go in college");
		try{
			Thread.sleep(1000);
		}catch(Exception e){}
		b.useBike();	
	}		
}
class Karim implements Runnable{
	Bike b;
	Karim(Bike b){
		this.b=b;
		Thread t=new Thread(this,"Karim");
		t.start();
		t.setPriority(10);
	}
	public void run(){
		System.out.println("Karim want to use bike to meet his GF");
		try{
			Thread.sleep(1000);
		}catch(Exception e){}
		b.useBike();
	}
}
class Jodu implements Runnable{
	Bike b;
	Jodu(Bike b){
		this.b=b;
		new Thread(this,"Jodu").start();
	}
	public void run(){
		System.out.println("Jodu want to use bike to meet his Friends");
		try{
			Thread.sleep(1000);
		}catch(Exception e){}
		b.useBike();
	}
}

class  Modhu implements Runnable{
	Bike b;
	Modhu(Bike b){
		this.b=b;
		new Thread(this,"Modhu").start();
	}
	public void run(){
		System.out.println("Modhu want to use bike for picnic");
		try{
			Thread.sleep(1000);
		}catch(Exception e){}
		b.useBike();
	}
}

class Driver{
	public static void main(String ... args){
		Bike b=new Bike();
		Rahim r=new Rahim(b);
		Karim k=new Karim(b);
		Jodu j=new Jodu(b);
		Modhu m=new Modhu(b);
	}	
}
