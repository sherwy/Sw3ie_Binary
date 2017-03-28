package com.logic;
import java.util.Vector;


public class CharToBinary {
	private String charactor ;
	Vector<String> charactorVec = new Vector<String>();
	
	public CharToBinary(String charactor){
		addChar();
		this.charactor = charactor.toLowerCase();
	}
	
	public String getBinary(){
		Vector<String> test = new Vector<String>();
		String binary = "" ;
		int sed = getNumOfChar() ;
		do{
			
			if((sed%2)==0){
				test.addElement("0");
			}else{
				test.addElement("1");
			}
			sed /= 2 ;
			if(sed==1){
				test.addElement("1");
			}
		}while(sed!=1 && sed!= 0);
		
		
		
		
		
		
		if(test.size()!=5){
			int count = 5 - test.size();
			for(int i=0 ; i < count ; i++){
				test.addElement("0");
			}
		}
		
		for(int i=test.size()-1 ; i >= 0 ; i--){
			binary += test.elementAt(i);
		}
		return binary ;
		
		
		
		
	}
	
	public int getNumOfChar(){
		int test  = 0 ;
		for(int i=0 ; i<charactorVec.size() ; i++){
			if(charactor.charAt(0)==charactorVec.elementAt(i).charAt(0)){
				test = i+1 ;
			}
		}
		return test ;
	}
	
	
	
	public void addChar(){
		char first = 'a' ;
		String sec = "";
		for(int i=0 ; i<26 ; i++,first++){
			sec = ""+ first ;
			charactorVec.addElement(sec);
		}
	}
}
