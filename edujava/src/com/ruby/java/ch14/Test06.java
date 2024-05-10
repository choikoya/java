package com.ruby.java.ch14;

interface MyFunc<T> {
	T modify(T t);
}

public class Test06 {

	public static void main(String[] args) {

		MyFunc<String> mf1 = (str) -> str.toUpperCase() + ":" + str.length(); //mf1 인터페이스의 객체 
		System.out.println(mf1.modify(0));
		System.out.println(mf1.modify("java programming"));

		MyFunc<Integer> mf2 = (n) -> n * 2; //n선언없음 > 
		System.out.println(mf2.modify("java"));
		System.out.println(mf2.modify(42));
	}
}

//