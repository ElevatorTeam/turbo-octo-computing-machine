package elevatorLogic;

public class WaitTime{
	
	long time;
	
	public WaitTime(){
		time = 0;
	}
	
	public void startTime(){
		time=System.currentTimeMillis();
		//System.out.println(time);
	}
	
	public double endTime(){
		if((System.currentTimeMillis() - time)>100000)
			System.out.println((System.currentTimeMillis() - time));
		return ((System.currentTimeMillis() - time)/1000);
	}
}