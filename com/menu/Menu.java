package com.menu;

import java.util.Scanner;


public class Menu {
	
	
	@SuppressWarnings("resource")
	public int printMenuAndChoice(){
		int choice = 0 ;
		System.out.println("=== Welcome Sw3ie ===");
		System.out.println("\t1.Text to Binary");
		System.out.println("\t2.Binary to Text");
		System.out.println("\t3.Exit");
		System.out.print("? ");
		
		choice = new Scanner(System.in).nextInt();
		
		return choice;
	}
	
	public void printErrorMenu(String txt){
		System.out.println("\n**************************************");
		System.out.println(txt);
		System.out.println("**************************************\n");
	}
}
