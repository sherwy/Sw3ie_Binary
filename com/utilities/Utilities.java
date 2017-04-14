package com.utilities;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Utilities {
	
	public static void printStringArray(String[] array){
		String texts = "";
		for(int i=0 ; i<array.length ; i++){
			String text = array[i];
			if(i!=0){
				text = "," + text;
			}
			texts += text;
		}
		System.out.println("Array of String : {"+texts+"}");
	}

	public static void printIntegerArray(Integer[] array){
		String texts = "";
		for(int i=0 ; i<array.length ; i++){
			String text = array[i]+"";
			if(i!=0){
				text = "," + text;
			}
			texts += text;
		}
		System.out.println("Array of Integer : {"+texts+"}");
	}
	
	public static void printStringList(List<String> list){
		for(String word : list){
			System.out.println(word);
		}
	}
	
	public static Integer[] getSortNumberArray(int size){
		Integer[] array = new Integer[size];
		for(int i=0 ; i< array.length ; i++){
			array[i] = i;
		}
		return array;
	}
	
	public static String getStringFromArrayIndex(String word,Integer[] indexContainer){
		System.out.println("word : "+word);
		String newWord = "";
		char[] listChar = new char[word.length()];
		for(int i=0 ; i<word.length() ; i++){
			int realIndex = indexContainer[i]-1;
			listChar[realIndex] = word.charAt(i);
		}
		for(int i=0 ; i<listChar.length ; i++){
			newWord += listChar[i];
		}
		return newWord;
	}
	
	public static String getValueFromArrayWithSherwyFormat(Integer[] array){
		String result = "";
		for(int number : array){
			String numberString = (number)+"";
			if(numberString.length() > 1){
				result += "("+number+")";
			}else{
				result += number;
			}
		}
		return result;
	}
	
	public static Integer[] randomArraysIndex(String word){
		Integer[] indexOfWord = getSortNumberArray(word.length());
		Integer[] container = new Integer[word.length()];
		for(int i=0 ; i<container.length ; i++){
			int rd = 0;
			do{
				rd =ThreadLocalRandom.current().nextInt(0, indexOfWord.length);
				if(indexOfWord[rd] != -1){
					container[i] = rd+1;
					indexOfWord[rd] = -1;
				}
			}while(indexOfWord[rd] != -1 || container[i] == null);
		}
		return container;
	}
}
