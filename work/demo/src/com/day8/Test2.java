package com.day8;

class Rect{
	
	private int w, h;

	public Rect(){
	}

	public Rect(int w, int h){
		this.w = w;
		this.h = h;
	}

	public void set(int w, int h){
		this.w = w;
		this.h = h;
	}
	
	public int area(){
		return w*h;
	}
	
	public int length(){
		return (w*h)*2;
	}
	
	public void print(int a){
		System.out.println("가로 : " + w + ", 세로 : " + h);
		System.out.println("넓이 : " + a);
	}

	public void print(int a, int l){
		System.out.println("가로 : " + w + ", 세로 : " + h);
		System.out.println("면적 : " + a);
		System.out.println("넓이 : " + l);
	}
}

public class Test2 {

	public static void main(String[] args) {

        System.out.println("기본생성자..........");
		Rect ob1 = new Rect();
		ob1.set(10, 20);
		
		int a = ob1.area();
		int l = ob1.length();
		
		ob1.print(a);
		ob1.print(a, l);
		
		System.out.println();
		System.out.println("생성자 오버로딩..........");
		Rect ob2 = new Rect(100, 200);
		
		a= ob2.area();
		l= ob2.length();
		
		ob1.print(a);
		ob2.print(a, l);
	}

}
