package com.logic;
import java.util.Vector;

public class BinaryToChar {
	Vector<String> charactorVec = new Vector<String>();
	private String binary;
	private int sum = 0;

	public BinaryToChar(String binary) {
		this.binary = binary;
		addChar();
	}

	public String getString() {
		return charactorVec.elementAt(getNumOfChar() - 1);
	}

	public int getNumOfChar() {
		int binaryS = 16 ;
		for (int i = 0; i < binary.length(); i++) {
			String test = "" + binary.charAt(i);
			if(Integer.parseInt(test)==1){
				sum += binaryS;
			}
			binaryS /= 2 ;
		}
		return sum;
	}

	public void addChar() {
		char first = 'a';
		String sec = "";
		for (int i = 0; i < 26; i++, first++) {
			sec = "" + first;
			charactorVec.addElement(sec);
		}
	}
}
