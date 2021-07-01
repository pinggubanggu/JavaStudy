package practise;

public class Tv {
	String color;
	int channel;
	boolean power;
	
	void powerOnOff() {
		power = !power;
	}
	
	void channelUp() {
		channel++;
	}
	
	void channelDown() {
		channel--;
	}
}
