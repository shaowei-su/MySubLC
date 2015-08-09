/**
 * 
 */
package leetcode;

import java.util.*;

/**
 * @author shaowei
 *
 */
public class Integer2Roman {

	/**
	 * @param args
	 * 1 I
	 * 5 V
	 * 10 X
	 * 50 L
	 * 100 C
	 * 500 D
	 * 1000 M
	 */
    public String intToRoman(int num) {
    	if (num < 1 || num > 4000) return "";
    	//convert int to arraylist
    	ArrayList<Integer> numArray = new ArrayList<Integer>();
    	int digit = 1000;
    	while (digit >= 1) {
    		numArray.add(num/digit);
    		num %= digit;
    		digit /= 10;
    	}
    	StringBuilder sb = new StringBuilder();
    	sb.append(convert(numArray.get(0), "M", "", ""));
    	sb.append(convert(numArray.get(1), "C", "D", "M"));
    	sb.append(convert(numArray.get(2), "X", "L", "C"));
    	sb.append(convert(numArray.get(3), "I", "V", "X"));
    	
    	return sb.toString();
    	
    	
        
    }
    
    public String convert(int num, String one, String five, String ten) {
    	StringBuilder sb = new StringBuilder();
    	switch(num) {
    		case 1:
    		case 2:
    		case 3:
    			for (int i = 0; i < num; i++) {
    				sb.append(one);
    			}
    			break;
    		case 4:
    			sb.append(one);
    			sb.append(five);
    			break;
    		case 5:
    			sb.append(five);
    			break;
    		case 6:
    		case 7:
    		case 8:
    			sb.append(five);
    			for (int i = 5; i < num; i++) {
    				sb.append(one);
    			}
    			break;
    		case 9:
    			sb.append(one);
    			sb.append(ten);
    			break;
    		default:
    			break;
    				
    	}
    	return sb.toString();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer2Roman i = new Integer2Roman();
		System.out.println(i.intToRoman(3444));

	}

}
