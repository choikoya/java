package com.ruby.java.ch14;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/* 과제목표 : 제네릭, 람다식으로 Comparator, compare 만들어서 정렬하기
/*
 * public interface Comparator<T>{
 *    int compare(T 01, T 02);
 *    }
 *    
 * public interface Comparable<T> {
 *   public int compareTo(T o);
 *   }   
 */


class Student { 
	String sno;
	String sname;
	
	public Student(String sno, String sname) { 
		// TODO Auto-generated constructor stub
		this.sno=sno; 
		this.sname=sname;

	}
	public String toString() { //함수
		
		return"(" +sno  + ", "+sname +")"; 
	}
}
//-----------------------------------------

public class 구현과제14장_람다식 {
	static void sortStudents() {

	}
	static void showStudents(String msg, Student[] sArray) { 
		System.out.println(msg + ":");
		for(int i=0 ; i<sArray.length ; i++) {
			System.out.print(sArray[i]+" ");
		}
		System.out.println();
	}

	

	
	
	public static void main(String[] args) {
//문제1: Arrays.sort()를 사용한 sArray 정렬 - sno 사용, 익명클래스 사용
	Comparator<Student> compSno = new Comparator<Student>(){ //제네릭
		@Override //재정의
		public int compare(Student s1, Student s2) {
			
		return Integer.parseInt(s1.sno) - Integer.parseInt(s2.sno);
			}
	};
	
	Comparator<Student> compSno2 = (s1,  s2) ->Integer.parseInt(s1.sno)-Integer.parseInt(s2.sno);
	
	
        Student[] sArray = new Student[5];
        
        // Student 객체 생성 및 배열에 할당
        sArray[0] = new Student("121", "Alice"); //함수호출. 생성자가없다고 오류 
        sArray[1] = new Student("33", "Bob");
        sArray[2] = new Student("9", "Charlie");
        sArray[3] = new Student("2", "John");
        sArray[4] = new Student("39", "Bobby");
        // ArrayList로 변환
        ArrayList<Student> sList = new ArrayList<>(); 
        for (Student student : sArray) {
            sList.add(student); 
        }
        showStudents("sno 정렬전", sArray); 
        //문제1: Arrays.sort()를 사용한 sArray 정렬 - sno 사용, 익명클래스 사용
        //Arrays.sort(sArray);
        Arrays.sort(sArray, compSno);
        showStudents("sno 정렬후", sArray);
        
        showStudents("sname 정렬전", sArray);
        //문제2: Arrays.sort()를 사용한 sArray 정렬 - sname 사용, 익명 객체 사용
        
        showStudents("sname 정렬후", sArray);
        
        

        showStudents("sno 정렬전", sList);
        //문제3: Collections.sort()를 사용한 sList 정렬 - sno 사용, 람다식 사용
        
        showStudents("sno 정렬후", sList);
        
        showStudents("sname 정렬전", sList);
        //문제4: Collections.sort()를 사용한 sList 정렬 - sname 사용
        
        showStudents("sname 정렬후", sList);
        
        
        showStudents("sno 정렬전", sArray);
        //문제5: sortStudents()를 사용한 sArray 정렬 - sno 사용
        showStudents("sname 정렬후", sArray);
	}

}
