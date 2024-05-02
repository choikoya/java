package Quiz;



abstract class Drink{ //추상 클래스 
	public abstract void drink(); //추상 메서드
}
	
	
class Juice extends Drink {
	
	@Override
	public void drink() {
		// TODO Auto-generated method stub
		System.out.println("주스를 마십니다");
	}
}
	
class Coffee extends Drink {
	
	@Override
	public void drink() {
		// TODO Auto-generated method stub
		System.out.println("커피를 마십니다");
	}
}

class Beer extends Drink{

	@Override
	public void drink() {
		// TODO Auto-generated method stub
		System.out.println("맥주를 마십니다");
	}
	
}
		
class Water extends Drink{
	public void drink() {
		System.out.println("물을 마십니다");
	}
}

class Tea extends Drink {
	
	@Override
	public void drink() {
		// TODO Auto-generated method stub
		System.out.println("차를 마십니다");
	}
}
		
//-----------------------------------------------
public class Drinks_07 {
	public static void main(String[] args) {
		Drink[] arr = new Drink[5]; 
		
		arr[0]  = new Juice();
		arr[1] = new Coffee();
		arr[2] = new Beer();
		arr[3] = new Water();
		arr[4] = new Tea();
		
//				
//		arr[0].drink();		
//		arr[1].drink();
//		arr[2].drink();
//		arr[3].drink();
//		arr[4].drink();
		
		
		for(int i=0; i<arr.length; i++) {
			arr[i].drink();
			
		}
		
	}
}

	
	