package referencetype;

public class TvPractise {

	public static void main(String[] args) {
		// MyTv 인스턴스 생성
		MyTv tv = new MyTv();
		
		System.out.println("tv.volume : " + tv.volume);
		System.out.println("tv.isPowerOntv : " + tv.isPowerOn);
		System.out.println("tv.channel : " + tv.channel);
		System.out.println();
		
		tv.volumeUp();
		System.out.println("메서드 실행 후 \n tv.volume : " + tv.volume);
		
		tv.turnOnOff();
		System.out.println("메서드 실행 후 \n tv.isPowerOn : " + tv.isPowerOn);
		
		tv.channelDown();
		System.out.println("메서드 실행 후 \n tv.channel : " + tv.channel);
		

	}

}
