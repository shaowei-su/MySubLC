import java.util.*;
//http://www.meetqun.com/thread-9248-1-1.html
class TrieNode {
	TrieNode[] children;
	boolean have;

	public TrieNode() {
		have = false;
		children = new TrieNode[26];
	}
}

public class WordDictionary {
	private TrieNode root;

	public WordDictionary() {
		root = new TrieNode();
	}

	public void addWord(String word) {
		TrieNode start = root;
		for (char c: word.toCharArray()) {
			if (start.children[c - 'a'] == null) {
				start.children[c - 'a'] = new TrieNode();
			}
			start = start.children[c - 'a'];
		}
		start.have = true;
	}

    public boolean search(String word) {
    	TrieNode start = root;
        return dfs(start, word, 0);
    }

    public boolean dfs(TrieNode start, String word, int pos) {
    	if (start == null || (word.length() == pos && !start.have)) {
    		return false;
    	}
    	if (word.length() == pos && start.have) {
    		return true;
    	}
    	char cur = word.charAt(pos);
    	if (cur == '.') {
    		for (int i = 0; i < 26; i++) {
    			if (dfs(start.children[i], word, pos + 1)) {
    				return true;
    			}
    		}
    	} else {
    		return dfs(start.children[cur - 'a'], word, pos + 1);
    	}

    	return false;
    }

    public static void main(String[] args) {
        WordDictionary dic = new WordDictionary();
        dic.addWord("apple");
        System.out.println(dic.search("appl."));
    }
}