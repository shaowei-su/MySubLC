import java.util.*;

public class Solution2 {
    public List<String> findRepeatedDnaSequences(String s) {
    	List<String> list = new ArrayList<String>();
        if (s == null || s.length() < 10) {
        	return list;
        }

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);

        HashSet<Integer> first = new HashSet<Integer>();
        HashSet<Integer> second = new HashSet<Integer>();
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {

            if (i < 9) {
                hash = (hash << 2) + map.get(s.charAt(i)); //add current char into hash
            } else {
                hash = (hash << 2) + map.get(s.charAt(i));
                hash = hash & (1 << 20) - 1; //remove those bits in hash that exceeds 20 bits
                // 1 << 20 - 1 generate 20 '1'
                if (first.contains(hash) && !second.contains(hash)) {
                    second.add(hash);
                    list.add(s.substring(i - 9, i + 1));
                } else {
                    first.add(hash);
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
    	Solution2 sol = new Solution2();
    	List<String> res = sol.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
    	for (String s: res) {
    		System.out.println(s);
    	}
    }
}