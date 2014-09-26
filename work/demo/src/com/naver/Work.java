package com.naver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.score4.ScoreVO;


public class Work implements Naver{
	List<Define> lists = new ArrayList<Define>();
	Scanner sc = new Scanner(System.in);
	private Define df;
	
		
	@Override
	public void input() throws Exception{
		Iterator<Define> it = lists.iterator();
		Define df = new Define();
		
		
		try {
		System.out.println("���̵� �Է� : ");
		df.setId(sc.next());
		
		while(it.hasNext()){
			Define df1 = it.next();
		if(df.getId().equals(df1.getId())){
			System.out.println("���� ���̵� �̹� �����մϴ�. �ٸ� ���̵� �Է��Ͻÿ�.");
			return;
		}
		else{
			System.out.println("��� ���̵� �Դϴ�. �Է� �����մϴ�.");
		}
		
		}
		if(df.getId().length() < 5 || df.getId().length() > 10) {
			throw new Exception("5~10�� �Է��ؾ� �˴ϴ� : " + df.getId());
		}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		System.out.println("��й�ȣ �Է� : ");
		df.setPass(sc.next());
		System.out.println("�̸� �Է� : ");
		df.setName(sc.next());
		System.out.println("���� �Է� : ");
		df.setSung(sc.next());
		System.out.println("��� �� �� �Է� : ");
		df.setBirth(sc.next());
		System.out.println("�̸��� �Է� : ");
		df.setEmail(sc.next());
		System.out.println("���ȣ �Է� : ");
		df.setPhone(sc.next());
		
		lists.add(df);
		System.out.println("�Է� �Ϸ�!!!");
		
	}

	@Override
	public void print() {
		System.out.println("< �� �� >");
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("���̵�     ��й�ȣ     �̸�     ����    ������        �̸���        ���ȣ ");
		System.out.println("------------------------------------------------------------------------------");
		for(Define d : lists){
		System.out.printf("%s %11s %8s %9s %11s %15s %15s \n", d.getId(), d.getPass(), d.getName(), 
				d.getSung(), d.getBirth(), d.getEmail(), d.getPhone());
		}
					
	}

	@Override
	public void delete() {
		Iterator<Define> it = lists.iterator();
		String did;
		int result = 0;
		
		System.out.println("������ ���̵� : ");
		did = sc.next();
		
		while(it.hasNext()){
			Define df = it.next();
			if(did.equals(df.getId())){
				it.remove();
				System.out.println("���� �Ϸ� �Ǿ���ϴ�.");
				result = 1;
			
			}
		}
			if(result == 0){
			System.out.println("������ ���̵� ����ϴ�.");
		}
		
		
	}
	
	
	@Override
	public void update() {
		Iterator<Define> it = lists.iterator();
		String uid;
		Define df = new Define();
		int result = 0;
		
		System.out.println("������ ���̵� �Է� : ");
		uid = sc.next();
		
		while(it.hasNext()){
			Define df1 = it.next();
			if(uid.equals(df1.getId())){
				it.remove();
				System.out.println("���� �����մϴ�.");
				result = 1;
				}
			
		}	if(result == 0){
			System.out.println("������ ���̵� ����ϴ�.");
			return;
			
		}
		
		
				
				System.out.println("���̵� �Է� : ");
				df.setId(sc.next());
				System.out.println("��й�ȣ �Է� : ");
				df.setPass(sc.next());
				System.out.println("�̸� �Է� : ");
				df.setName(sc.next());
				System.out.println("���� �Է� : ");
				df.setSung(sc.next());
				System.out.println("��� �� �� �Է� : ");
				df.setBirth(sc.next());
				System.out.println("�̸��� �Է� : ");
				df.setEmail(sc.next());
				System.out.println("���ȣ �Է� : ");
				df.setPhone(sc.next());
				
				lists.add(df);
				System.out.println("���� �Ϸ�!!!");
				
			
			
		
	}


	@Override
	public void findId() {
		Iterator<Define> it = lists.iterator();
		String fid;
		int result=0;

		System.out.println("ã�� ���̵� : ");
		fid = sc.next();

		while(it.hasNext()){
			Define df = it.next();
			if(fid.equals(df.getId())){
				System.out.println("ã�� ���̵� �����Ѵ�" + " " +  df.getId());
				result=1;
			}
		}
		if(result == 0)
			System.out.println("���");
	}

	@Override
	public void findName() {
		Iterator<Define> it = lists.iterator();
		String fname;
		int result=0;

		System.out.println("ã�� �̸�: ");
		fname = sc.next();

		while(it.hasNext()){
			Define df = it.next();
			if(fname.equals(df.getName())){
				System.out.println("ã�� �̸��� �����Ѵ�" + " " +  df.getName());
				result=1;
			}
		}
		if(result == 0)
			System.out.println("���");
	}

	
	

}
















