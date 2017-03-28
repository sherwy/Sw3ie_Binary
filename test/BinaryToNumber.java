package test;

import java.util.Vector;

public class BinaryToNumber {
    Vector<String> charactorVec = new Vector<String>();
    private String binary;

    public BinaryToNumber(String binary) {
        this.binary = binary;
    }

    public int getNumber() {
        int sum = 0;
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


}
