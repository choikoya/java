package com.ruby.java.ch12;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(FileInputStream fi = new FileInputStream("a.txt");
				FileOutputStream fo = new FileOutputStream("b.txt");){
			int c = 0;
			//char ch;
			while((c = fi.read()) != -1){
				//ch = (char)c;
				fo.write(c);
				//System.out.println(c+"\t"+Integer.toHexString(c)+"\t"+ch);
				System.out.println(c+"\t"+Integer.toHexString(c)+"\t"+(char)c);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}