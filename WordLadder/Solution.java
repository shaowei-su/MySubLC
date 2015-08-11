import java.util.*;

public class Solution {

	public String replace(String s, int i, char c) {
		char[] charArray = s.toCharArray();
		charArray[i] = c;

		return new String(charArray);
	}

    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        if (wordDict == null || wordDict.size() == 0) {
        	return 0;
        }

        LinkedList<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        wordDict.remove(beginWord);
        int length = 1;
        while (!queue.isEmpty()) {
        	int count = queue.size();
        	for (int j = 0; j < count; j++) {
	        	String crt = queue.poll();
	        	for (char c = 'a'; c <= 'z'; c++) {
	        		for (int i = 0; i < crt.length(); i++) {
	        			if (c == crt.charAt(i)) {
	        				continue;
	        			}
	        			String replaced = replace(crt, i, c);
	        			if (replaced.equals(endWord)) {
	        				return length + 1;
	        			}

	        			if (wordDict.contains(replaced)) {
	        				queue.offer(replaced);
	        				wordDict.remove(replaced);
	        			}
	        		}
	        	}
        	}
        	length++;
        }

        return 0;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	Set<String> wordDict = new HashSet<String>();
    	wordDict.add("hot");
    	wordDict.add("dot");
    	wordDict.add("dog");
    	wordDict.add("lot");
    	wordDict.add("log");

    	System.out.println(sol.ladderLength("hit", "cog", wordDict));
    }
}