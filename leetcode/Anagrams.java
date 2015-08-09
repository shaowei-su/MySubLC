package leetcode;

import java.util.*;
public class Anagrams {

    public List<String> anagrams(String[] strs) {
        //edge cases
    	if (strs == null || strs.length == 0) {
    		return null;
    	}
    	
    	HashMap<String, ArrayList<Integer>> anagrams = new HashMap<String, ArrayList<Integer>>();
    	List<String> res = new ArrayList<String>();
    	
    	for (int i = 0; i < strs.length; i++) {
    		char[] stringArray = strs[i].toCharArray();
    		Arrays.sort(stringArray);
    		//String temp = stringArray.toString();
    		String temp = String.valueOf(stringArray);
    		if (anagrams.containsKey(temp)) {
    			anagrams.get(temp).add(i);
    		} else {
    			ArrayList<Integer> newList = new ArrayList<Integer>();
    			newList.add(i);
    			anagrams.put(temp, newList);
    		}
    	}
    	
    	for (ArrayList<Integer> l: anagrams.values()) {
    		if (l.size() > 1) {
    			for (Integer i: l) {
    				res.add(strs[i]);
    			}
    		}
    	}
    	
    	
    	return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Anagrams a = new Anagrams();
		String[] strs = {"", ""};
		List<String> l = a.anagrams(strs);
		for (String s: l) {
			System.out.println(s);
		}
	}

}
