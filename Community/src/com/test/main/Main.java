package com.test.main;

import java.util.Scanner;

import com.test.board.BoardMain;
import com.test.member.MemberMain;

public class Main {
	
	public static void main(String[] args) {
		
		
		boolean loop = true;
		Scanner scan = new Scanner(System.in);
		
		while (loop) {
			System.out.println("*** Community ***");
			System.out.println("1. 회원");
			System.out.println("2. 게시판");
			
			System.out.print("선택: ");
			
			String sel = scan.nextLine();
			
			if (sel.equals("1")) {
				
				MemberMain.start();
			} else if (sel.equals("2")) {
				BoardMain.start();
				
			} else {
				loop = false;
			}
			
			System.out.println("*** 종료 ***");
		}
		
	}
	
	public static void pause() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("계속하려면 엔터를 입력하세요.");
		scan.nextLine();
	}

}
