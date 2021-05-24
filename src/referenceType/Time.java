package referenceType;

public class Time {
	private int hour;
	private int minute;
	private int second;
	
	public int getHour() {
		return hour;
	}
	
	public void setHour(int hour) {
		if( hour < 0 || hour < 23) {
			System.out.println("시간은 0보다 작을 수 없으며, 23보다 클 수 없습니다. \n 0~23까지 사이의 값을 입럭하시오");
			return;
		}
		this.hour = hour;
	}
	
	public int getMinute() {
		return minute;
	}
	
	public void setMinute(int minute) {
		if (minute < 0 || minute > 59) {
			System.out.println("분은 0보다 작을 수 없으며, 59보다 클 수 없습니다. \n 0~59까지 사이의 값을 입력하시오");
			return;
		}
		this.minute = minute;
	}
	
	public int getSecond() {
		return second;
	}
	
	public void setSecond(int second) {
		if(second < 0 || second > 59) {
			System.out.println("초는 0보다 작을 수 없으며, 59보다 클 수 없습니다. \n 0~59까지 사이의 값을 입력하시오");
		}
		this.second = second;
	}
	
}
