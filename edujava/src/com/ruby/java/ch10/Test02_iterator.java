
package com.ruby.java.ch10;
//실습 대상 - 교재 459-460 설명 소스 코드 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
class Employee {
	String name;
	int age;
	int height;
	int weight;
	String blood_type; 
	String email;
	public Employee(String name, int age, int height, int weight, String blood_type, String email) {
		this.name =name;this.age=age;this.height=height;this.weight=weight;this.blood_type=blood_type; this.email=email;
	}
	public Employee() {}
	public String toString() {
		return name + " : " + age + " : " + height + " : " + weight + " : " + blood_type + " : " + email;
	}
}
/*
* public interface Comparator<T> {
  int compare(T o1, T o2);
 }
*/
class EmpComparator implements Comparator<Employee> {
	@Override
	public int compare(Employee e1, Employee e2) {
		return e1.name.compareTo(e2.name);
	}
}


public class Test02_iterator {

	public static void main(String[] args) {
		// Comparator 객체 생성 - 익명클래스
		Comparator<String> comparator = new Comparator<String>() {
		    @Override
		    public int compare(String o1, String o2) {
		        return o1.compareTo(o2); // 문자열을 사전순으로 비교
		    }
		};
		//page 459 그림
		Employee e1 = new Employee("호머심슨",39,182,142, "RH(_)B", "chukylover53");
		Employee e2= new Employee("가제트",40,184,120,"A","gadget");
		Employee e3 = new Employee("신형만",35,180,80,"O","jjangu");
		
		Employee e10 = new Employee();
		
		//page 460 그림
		Employee [] arr = new Employee[5];
		arr[0] = e1;arr[1] = e2; arr[2] = e3;
		//
		arr[4] = new Employee();
		
		int [] num = new int[5];
		num[0] = 10;num[1] = 20; num[2] = 30; //num[1] = 15;// 삽입하려면  
		
		Object arr2[] = new Object[10];
		arr2[0]=e1;
		arr2[1]=e2;
		arr2[2]=e3;
			
		String s = "java";
		Integer ix = 123;
		arr2[3] = s;
		arr2[4] = ix;
		//int len = arr2[0].length();//에러이다 arr2[0].에 나타나는 메소드는 Object 메소드만 있다: 교재 466페이지 마지막 문단 
		int len2 = ((String)arr2[3]).length();
		
		ArrayList lst = new ArrayList(); //크기가 10인 리스트를 생성
		lst.add(s);
		lst.add(ix);
		//int len3 = list.get(0).length();//오류 > list.get(0).은 Object이기 때문이다.
		int len4 = ((String)lst.get(0)).length();
		
		//페이지 468 -  generic 타입을 학습
		//ArrayList<sting> list new ArrayList<string>(); new ArrayList<sting>();만들엉진 객체
		List<String> list = new ArrayList<String>();//list는 참조변수(그 아래의 객체를 다 가짐)크기가 10인 리스트 생성
		list.add("서울");
		list.add("북경");
		list.add("상해");
		list.add("서울");
		list.add("도쿄");
		list.add("뉴욕");
		int len5 = list.get(0).length();//list.get(0).은 String을 반환한다 이유는 생성자에서 T가 String으로 선언
		//E get(int index) >> generic으로 선언된 데이터 타입이므로 
		Collections.sort(list);
		//list.sort(comparator);
		System.out.println("0: 정렬후:: ");
		for (String element : list) {
			System.out.print(element+" ");
		}
		System.out.println();
		
		for (int i = 0; i <list.size(); i++)
			System.out.print("list.size()를 사용한 출력:: " + list.get(i));
		
		System.out.println("\n==============");
		System.out.println("1: " + list.toString());//ArrayList에 override된 메소드
		
		//*중요//
		Iterator<String> iter = list.iterator();//Cursor커서라는 객체를 만들어서 iter라는 참조변수가 객체를 가리킴//iterator()클래스는 iterator<String> 객체를 반환
		//480페이지 1번째 문단 
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");//iter가 커서가 가리키는 곳을 읽어와라
		}
		//*여기까지 이해하기
		
		
		System.out.println();
		ArrayList<Employee> elist = new ArrayList<>();
		elist.add(new Employee("kim", 1,2,3, "A", "kim@gmail.com"));
		elist.add(new Employee("hong", 11,12,13, "B", "hong@gmail.com"));
		elist.add(new Employee("Choi", 12,62,23, "O", "Choihong@gmail.com"));
		elist.add(new Employee("han", 21,72,33,"A", "hanhong@gmail.com"));
		elist.add(new Employee("Go", 31,82,43, "B", "gohong@gmail.com"));
		//elist.add("hong");//오류 이유는? -> elist는 Employee 객체만 가질 수 있다 
		//정렬1: 
		//Collections.sort(elist, new EmpComparator());
		//정렬2: 
		
		elist.sort(new EmpComparator());
		for (Employee ee: elist)
			System.out.println(ee.toString());
		System.out.println();
		Employee[]emparr = new Employee[elist.size()];
		elist.toArray(emparr);
		//정렬3: 
		Arrays.sort(emparr,new EmpComparator() );

		for (Employee ee2: emparr)
			System.out.println(ee2.toString());
	}
}