package com.logic;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class menuBinaryToChar {
	Scanner scan = new Scanner(System.in);
	private String word;
	List<String> wordVec = new Vector<>();
	List<String> listSentence = new Vector<>();
	List<List<Integer>> indexContainer = new Vector<>();
	boolean needsRandom = false;

	public menuBinaryToChar() {

		System.out.print("Random ? (y to access) : ");
		String isRandomString = scan.nextLine();

		needsRandom = isRandomString.equalsIgnoreCase("y");
		if (needsRandom) {
			System.out.println("\n\t\tBinary to Text (random)");
		} else {
			System.out.println("\n\t\tBinary to Text");
		}

		System.out.print("input : ");
		word = scan.nextLine();

		if (needsRandom)
			random();

		addWord();
		printWord();

	}

	public void random() {
		String[] splitted = word.split("-");
		String indexString = splitted[0].trim();
		word = splitted[1].trim();
		setIndexContainer(indexString);
	}

	public void setIndexContainer(String indexString) {
		String[] indexs = indexString.split(" ");
		for (String indexWord : indexs) {
			List<Integer> container = new Vector<>();
			String temp = "";
			boolean isMoreThanOneChar = false;
			for (int i = 0; i < indexWord.length(); i++) {
				char currentChar = indexWord.charAt(i);

				if (currentChar == '(') {
					isMoreThanOneChar = true;
				} else if (currentChar == ')') {
					isMoreThanOneChar = false;
					container.add(Integer.parseInt(temp));
					temp = "";
				} else {
					if (isMoreThanOneChar) {
						temp += currentChar;
					} else {
						container.add(Integer.parseInt(currentChar + ""));
					}
				}
			}
			indexContainer.add(container);
		}
	}

	public void addWord() {
		String[] sentence = word.split(" ");
		for (int i = 0; i < sentence.length; i++) {
			String sentenceSplitted = sentence[i];
			String[] wordSplitted = sentenceSplitted.split("\\.");
			String wordTest = "";
			for (int j = 0; j < wordSplitted.length; j++) {
				BinaryToChar btc = new BinaryToChar(wordSplitted[j]);
				wordTest += btc.getString();
			}
			listSentence.add(wordTest);
		}
	}

	public void printWord(){
		System.out.println("=========== Result ===========");
		for(int i=0 ; i<listSentence.size() ; i++){
			if(i!=0){
				System.out.print(" ");
			}
			
			String sentence = listSentence.get(i);
			if(needsRandom){
				List<Integer> container = indexContainer.get(i);
				for(int j=0 ; j<container.size(); j++){
					System.out.print(sentence.charAt(container.get(j)-1));
				}
			}else{
				System.out.print(sentence);
			}
		}
		System.out.println("\n==============================");
		System.out.println();
	}
}
