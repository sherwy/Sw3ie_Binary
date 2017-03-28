package com.logic;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class menuCharToBinary {
	Scanner scan = new Scanner(System.in);
	private String word;
	List<String> binaryVec = new Vector<>();
	List<List<String>> listWords = new Vector<>();

	public menuCharToBinary() {
		System.out.println("\t\tText to Binary");
		System.out.print("input : ");
		word = scan.nextLine();
		getBinary();
		printBinary();
	}

	public void getBinary() {
		String[] words = word.split(" ");
		
		for (String wordSplitted : words) {
			System.out.println(wordSplitted);
			List<String> sentence = new Vector<>();
			for (int i = 0; i < wordSplitted.length(); i++) {
				String test = "" + wordSplitted.charAt(i);
				CharToBinary c = new CharToBinary(test);
				sentence.add(c.getBinary());
			}
			listWords.add(sentence);
		}
		
	}

	public void printBinary() {
		System.out.println("=========== Result ===========");
		for (List<String> binaryVecs : listWords) {
			for (int i = 0; i < binaryVecs.size(); i++) {
				if (i == 0) {
					System.out.print(binaryVecs.get(i));
				} else {
					System.out.print("." + binaryVecs.get(i));
				}
			}
			System.out.print(" ");
		}
		System.out.println("\n==============================");
		System.out.println();
	}

}
