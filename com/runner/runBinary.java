package com.runner;


import com.logic.menuBinaryToChar;
import com.logic.menuCharToBinary;
import com.menu.Menu;

public class runBinary {

	
	public static void main(String[] args) {
		Menu menu = new Menu();

		int choice = 0;
		do {
			try {
				choice = menu.printMenuAndChoice();
				if (choice == 1) {
					@SuppressWarnings("unused")
					menuCharToBinary ctb = new menuCharToBinary();
				} else if (choice == 2) {
					@SuppressWarnings("unused")
					menuBinaryToChar btc = new menuBinaryToChar();
				}else if (choice == 3 ){
					menu.printErrorMenu("Stopped");
					break;
				}else{
					menu.printErrorMenu("Invalid number, try again");
				}
			} catch (Exception e) {
				menu.printErrorMenu("Something wrong, try again");
				choice = 0;
			}
		} while (choice <=3 || choice >= 0);
		System.out.println("\t\t\tgtoNam :)");
	}

}
