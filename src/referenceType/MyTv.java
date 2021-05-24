package referenceType;

public class MyTv {
	boolean isPowerOn;
	int channel = 1;
	int volume;
	
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;
	
	void turnOnOff() {
		isPowerOn = !isPowerOn;
		
	}
	
	void volumeUp() {
		if(volume < MAX_VOLUME) {
			volume++;
		}
	}
	
	void volumeDown() {
		if(volume > MIN_VOLUME) {
			volume--;
		}
	}
	
	void channelUp() {
		if(channel == MAX_CHANNEL) {
			channel = MIN_CHANNEL;
		} else { channel++; }
		
	}
	
	void channelDown() {
		if(channel == MIN_CHANNEL) {
			channel = MAX_CHANNEL;
		}	else { channel--; }
		
	}
}
