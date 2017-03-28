package com.logic;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import com.utilities.Utilities;

public class menuBinaryToChar {
	Scanner scan = new Scanner(System.in);
	private String word ;
	List<String> wordVec = new Vector<>();
	List<String> listSentence = new Vector<>();
	
	public menuBinaryToChar(){
		System.out.println("\t\tBinary to Text");
		System.out.print("input : ");
		word = scan.nextLine();
		addWord();
		printWord();
	}
	
	public void addWord(){
		String[] sentence = word.split(" ");
		for(int i=0 ; i<sentence.length ;i++){
			String sentenceSplitted = sentence[i];
			String[] wordSplitted = sentenceSplitted.split("\\.");
			String wordTest = "";
			for(int j=0 ; j<wordSplitted.length ; j++){
				BinaryToChar btc = new BinaryToChar(wordSplitted[j]);
				wordTest += btc.getString();
			}
			System.out.println(wordTest);
			listSentence.add(wordTest);
		}
		/*
		Scanner read = new Scanner(word);
		while(read.hasNext()){
			BinaryToChar btc = new BinaryToChar(read.next());
			wordVec.add(btc.getString());
		}
		*/
	}
	
	public void printWord(){
		System.out.println("=========== Result ===========");
		for(int i=0 ; i<listSentence.size() ; i++){
			if(i==0){
				System.out.print(listSentence.get(i));
			}else{
				System.out.print(" "+listSentence.get(i));
			}
		}
		System.out.println("\n==============================");
		System.out.println();
	}
}
