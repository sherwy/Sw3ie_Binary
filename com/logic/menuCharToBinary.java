package com.logic;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import com.utilities.Utilities;

public class menuCharToBinary {
	Scanner scan = new Scanner(System.in);
	private String word;
	List<List<String>> listWords = new Vector<>();
	List<Integer[]> indexContainer = new Vector<>();
	boolean needsRandom = false;

	public menuCharToBinary() {
		System.out.print("Random ? (y to access) : ");
		String isRandomString = scan.nextLine();
		
		needsRandom = isRandomString.equalsIgnoreCase("y");
		if(needsRandom){
			System.out.println("\n\t\tText to Binary (random)");
		}else{
			System.out.println("\n\t\tText to Binary");
		}
		System.out.print("input : ");
		word = scan.nextLine();

		if (needsRandom)
			random(word);
		
		getBinary();
		printBinary();

	}

	public void random(String word) {
		String[] words = word.split(" ");
		String[] newWords = new String[words.length];
		this.word = "";
		for (int i = 0; i < words.length; i++) {
			Integer[] randomIndex = Utilities.randomArraysIndex(words[i]);
			randomIndex = sortIntegerArray(randomIndex);
			newWords[i] = Utilities.getStringFromArrayIndex(words[i], randomIndex);
			this.word += newWords[i]+" ";
			indexContainer.add(randomIndex);
		}
	}
	
	public Integer[] sortIntegerArray(Integer[] array){
		Integer[] temp = new Integer[array.length];
		for(int i=0 ; i<array.length ; i++){
			for(int j=0 ; j<array.length ; j++){
				if((array[j]-1) == i){
					temp[i] = j+1;
					break;
				}
			}
		}
		return temp;
	}
	
	public void getBinary() {
		String[] words = word.split(" ");
		System.out.println("-- words --");
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
		if (needsRandom) {
			String result = "";
			String indexResult = "";
			System.out.println("=========== Result ===========");

			// word
			for (int i = 0; i < listWords.size(); i++) {
				List<String> binaryVecs = listWords.get(i);
				Integer[] wordIndexContainer = indexContainer.get(i);
				// char
				for (int j = 0; j < binaryVecs.size(); j++) {
					if (j == 0) {
						result += binaryVecs.get(j);
					} else {
						result += "." + binaryVecs.get(j);
					}
				}
				indexResult += Utilities.getValueFromArrayWithSherwyFormat(wordIndexContainer)+ " ";
				result += " ";
			}
			System.out.println(indexResult + " - " + result);
			System.out.println("==============================");
			System.out.println();
		}else{
			String result = "";
			System.out.println("=========== Result ===========");

			// word
			for (int i = 0; i < listWords.size(); i++) {
				List<String> binaryVecs = listWords.get(i);
				// char
				for (int j = 0; j < binaryVecs.size(); j++) {
					if (j == 0) {
						result += binaryVecs.get(j);
					} else {
						result += "." + binaryVecs.get(j);
					}
				}
				result += " ";
			}
			System.out.println("Result : " + result);
			System.out.println("==============================");
			System.out.println();
		}
	}

}
