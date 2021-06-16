package referencetype;

class Product {
	int price;
	int bonusPoint;
	
	Product(int price){
		this.price = price;
		bonusPoint = price/10;		// 보너스점수는 제품가격의  10%
	}
	
	Product() { }					// 기본 생성자
	
	// 기본 생성자가 컴파일러에 의해서 추가되는 경우는 
	// 클래스에 정의된 생성자가 하나도 없을 때 뿐이다.
	// 그래서 매개변수가 있는 생성자를 만들고 기본생성자를 만들어 놓지 않고
	// 그 클래스에 해당하는 인스턴스를 생성하면,
	// 매개변수도 없고 아무런 내용도 없는 인스턴스를 생성 할 수 가 없다.
	// 아까 만들어놓은 매개변수가 들어간 생성자에 의한 인스턴스만 만들수 있다.
	
}

class Tv1 extends Product{
	Tv1() {
		// 조상클래스의 생성자 Product(int price)을 호출한다.
		// 조상멤버는 조상 생성자로 초기화하기
		super(100);
	}
	
	public String toString() { return "Tv"; }	
}

class Computer extends Product {
	Computer() {
		
		super(200);
	}
	
	public String toString() { return "Computer"; }
}

class Buyer {
	int money = 1000;
	int bonusPoint = 0;
	Product[] cart = new Product[10];		// 구입한 제품을 저장하기 위한 배열
	int i = 0; 							// Product배열에 사용될 카운터
	void buy(Product p) {
		if(money < p.price) {
			System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
			return;
		}
		
		money -= p.price;
		bonusPoint += p.bonusPoint;
		cart[i++] = p;		// 제품을 Product[] cart에 저장한다.
		System.out.println(p + "을/를 구입하셨습니다.");
	}	
	
	void summary() {
		int sum = 0;			// 구입한 물품의 가격합계
		String itemList = "";	// 구입한 물품목록
		
		// 반복문을 이용해서 구입한 물품의 총 가격과 목록을 만든다.
		for(int i=0; i<cart.length; i++ ) {
			if(cart[i] == null) break;
			
			sum += cart[i].price;
			itemList += cart[i] + ", ";		// 참조변수 -> toString()호출
		
		}
		System.out.println("구입하신 물품의 총금액은 " + sum + "만원입니다.");
		System.out.println("구입하신 제품은 " + itemList + "입니다.");
	}
}



public class ParameterPolymorphism {

	public static void main(String[] args) {
		Buyer b = new Buyer();
		
		b.buy(new Tv1());
		b.buy(new Computer());
		
		System.out.println("현재 남은 돈은 " + b.money + "만원입니다.");
		System.out.println("현재 bonusPoint는 " + b.bonusPoint + "점입니다.");
		b.summary();

	}

}
