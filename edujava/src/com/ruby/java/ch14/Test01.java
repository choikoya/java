package com.ruby.java.ch14;

interface MyInterface {
	public void print();
}

class MyClass1 implements MyInterface { //interface 구현
	@Override
	public void print() {
		System.out.println("MyClass1의 객체");
	}
}

class MyClass2 implements MyInterface {
	@Override
	public void print() {
		System.out.println("MyClass2의 객체");
	}
}

public class Test01 {
	public static void test(MyInterface mi) {
		mi.print();
	}

	public static MyInterface test2() {
//방법2:익명클래스 사용
		MyInterface mi = new MyInterface() {//mi
			@Override
			public void print() {
				System.out.println("test2()메서드에서 반환된 MyInterface");
			}
		};
		return mi;
	}

	public static void main(String[] args) {
//방법
		MyClass1 mc1 = new MyClass1();
		MyClass2 mc2 = new MyClass2();
		mc1.print(); // MyClass1
		mc2.print(); // MyClass2
//방법2: 익명클래스 사용
		MyInterface mi = new MyInterface() {
			@Override
			public void print() {
				System.out.println("익명 클래스로 구현");
			}
		};
		

		mi.print(); // 익명 클래스로 구현
		
//방법3:익명 클래스 선언, 익명 객체 생성, method 호출
		(new MyInterface() { //new는 생성자 호출 {}로 익명클래스 만들어 생성자처럼 행세하겠다. 객체만듦
			@Override
			public void print() {
				System.out.println("선언, 생성, 호출을 한번에 처리");
			}
		}).print(); // 선언, 생성, 호출을 한번에 처리
//방법4:매개변수
		
		test(mc1); // MyClass1
		test(mi); // 익명 클래스로 구현
		//방법5.리턴타입
		
		MyInterface mi2 = test2();
		mi2.print(); // test2() 메서드에서 반환된 MyInterface
	}
}