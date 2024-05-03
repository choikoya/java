package com.ruby.java.ch12;

import java.io.BufferedReader;
import java.io.FileReader;

public class Testtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(BufferedReader br = new BufferedReader(new FileReader("m1.txt"))){
			
			
			String str;
			
			while((str = br.readLine()) != null){
				String[] arr = str.split(" "); 
				for(int i=0; i<arr.length; i++) {
					System.out.print(arr[i]+"\t");
				}
				System.out.println();
				
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e);
		}
	}
}

