package leetcode;

import java.util.*;

public class SubstringwithConcatenationofAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        //edge cases
    	if (s == null || s.length() == 0 || words.length == 0) {
    		return null;
    	}
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	
    	//map the inputed string array
    	HashMap<String, Integer> map = new HashMap<String, Integer>();
    	for (int i = 0; i < words.length; i++) {
    		if (map.containsKey(words[i])) {
    			map.put(words[i], map.get(words[i]) + 1);
    		} else {
    			map.put(words[i], 1);
    		}
    	}
    	int wLength = words[0].length();
    	String sub = "";
    	int count = 0;
    	int start = 0;
    	//two for loop, one go through each character in length of word[0] and the inner one go through each possible combination
    	
    	for (int i = 0; i < wLength; i++) {
    		start = i;
    		count = 0;
        	HashMap<String, Integer> temp = new HashMap<String, Integer>();
    		for (int j = i; j <= s.length() - wLength; j += wLength) {
    			sub = s.substring(j, j + wLength);
    			
    			if (map.containsKey(sub)) {
    				if (temp.containsKey(sub)) {
    					temp.put(sub, temp.get(sub) + 1);
    				} else {
    					temp.put(sub, 1);
    				}
    				count++;
    				//what if this sub is already enough in temp? keep moving right until the numbers is equal again
    				while (temp.get(sub) > map.get(sub)) {
    					String left = s.substring(start, start + wLength);
    					temp.put(left, temp.get(left) - 1);
    					count--;
    					start += wLength;
    				}
    				if (count == words.length) {
    					res.add(start);
    					String left = s.substring(start, start + wLength);
    					temp.put(left, temp.get(left) - 1);
    					start += wLength;
    					count--;
    				}
    				
    			} else {
    				temp.clear();
    				count = 0;
    				start = j + wLength;
    			}
    		}
    	}
    	
    
    	return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubstringwithConcatenationofAllWords s = new SubstringwithConcatenationofAllWords();
		String[] t = {"good", "good", "word", "best"};
		List<Integer> l = s.findSubstring("wordgoodgoodgoodbestword", t);
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i));
		}
	}

}
