import java.util.*;

public class Solution {


	public String replace(String s, int i, char c) {
		char[] chars = s.toCharArray();
		chars[i] = c;
		return (new String(chars));
	}

	public int findMinHelper(String start, String end, Set<String> dict) {
		Set<String> dictCopy = new HashSet<String>(dict);
		LinkedList<String> queue = new LinkedList<String>();
		queue.offer(start);
		dictCopy.remove(start);
		int length = 1;
		while (!queue.isEmpty()) {
			int count = queue.size();
			for (int i = 0; i < count; i++) {
				String crt = queue.poll();
				for (char c = 'a'; c <= 'z'; c++) {
					for (int j = 0; j < crt.length(); j++) {
						if (c == crt.charAt(j)) {
							continue;
						}
						String replaced = replace(crt, j, c);
						if (replaced.equals(end)) {
							return length + 1;
						}
						if (dictCopy.contains(replaced)) {
							queue.offer(replaced);
							dictCopy.remove(replaced);
						}
					}
				}
			}
			length++;
		}

		return 0;
	}

	public void findHelper(List<List<String>> res, List<String> temp, Set<String> dict, int min, int pos, String start, String end) {
		if (pos == min && temp.get(temp.size() - 1).equals(end)) {
			res.add(new ArrayList<String>(temp));
			return;
		}
		String last = temp.get(temp.size() - 1);
		for (char c = 'a'; c <= 'z'; c++) {
			for (int i = 0; i < last.length(); i++) {
				if (c == last.charAt(i)) {
					continue;
				}
				String replaced = replace(last, i, c);

				if (dict.contains(replaced)) {
					temp.add(replaced);
					dict.remove(replaced);
					findHelper(res, temp, dict, min, pos + 1, start, end);
					dict.add(replaced);
					temp.remove(temp.size() - 1);
				}
			}
		}

		return;
	}

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        if (dict == null || dict.size() == 0) {
        	return null;
        }

        int min = findMinHelper(start, end, dict);
        if (min == 0) {
        	return null;
        }
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> temp = new ArrayList<String>();
        temp.add(start);
        dict.add(end);
        findHelper(res, temp, dict, min, 1, start, end);

        return res;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	Set<String> dict = new HashSet<String>();
    	dict.add("hot");
    	dict.add("dot");
    	dict.add("dog");
    	dict.add("lot");
    	dict.add("log");
    	List<List<String>> res = sol.findLadders("hit", "cog", dict);
    	for (List<String> list: res) {
    		System.out.println(list);
    	}
    }
}