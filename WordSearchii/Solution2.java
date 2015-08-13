import java.util.*;

public class Solution2 {

	class TrieNode {
		TrieNode[] children = new TrieNode[26];
		String val = "";
	    // Initialize your data structure here.
	    public TrieNode() {
	        
	    }
	}

	public class Trie {
	    private TrieNode root;

	    public Trie() {
	        root = new TrieNode();
	    }

	    // Inserts a word into the trie.
	    public void insert(String word) {
	        TrieNode node = root;

	        for (char c: word.toCharArray()) {
	        	if (node.children[c - 'a'] == null) {
	        		node.children[c - 'a'] = new TrieNode();
	        	}
	        	node = node.children[c - 'a'];
	        }

	        node.val = word;
	    }

	    // Returns if the word is in the trie.
	    public boolean search(String word) {
	        TrieNode node = root;

	        for (char c: word.toCharArray()) {
	        	if (node.children[c - 'a'] == null) {
	        		return false;
	        	}
	        	node = node.children[c - 'a'];
	        }
	        return node.val.equals(word);
	    }

	    // Returns if there is any word in the trie
	    // that starts with the given prefix.
	    public boolean startsWith(String prefix) {
	        TrieNode node = root;

	        for (char c: prefix.toCharArray()) {
	        	if (node.children[c - 'a'] == null) {
	        		return false;
	        	}
	        	node = node.children[c - 'a'];
	        }
	        return true;
	    }
	}
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet<String>(); 
        // why set? cause there might be duplicates
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
            return new ArrayList();
        }

        Trie trieTree = new Trie();
        for (int i = 0; i < words.length; i++) {
        	trieTree.insert(words[i]);
        }
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
            	findHelper(res, board, i, j, visited, "", trieTree);
            }
        }

        return new ArrayList(res);
    }

    public void findHelper(Set<String> res, char[][] board, int i, int j, boolean[][] visited, String crt, Trie trieTree) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }
        if (visited[i][j]) {
        	return;
        }
        crt += board[i][j];
        if (!trieTree.startsWith(crt)) {
        	return;
        }
        if (trieTree.search(crt)) {
        	res.add(crt);
        }

        visited[i][j] = true;
        findHelper(res, board, i + 1, j, visited, crt, trieTree);
        findHelper(res, board, i - 1, j, visited, crt, trieTree);
        findHelper(res, board, i, j + 1, visited, crt, trieTree);
        findHelper(res, board, i, j - 1, visited, crt, trieTree);
        visited[i][j] = false;

        return;
    }

    public static void main(String[] args) {
    	Solution2 sol = new Solution2();
    	char[][] board = {{'a'}};
    	String[] words = {"a"};
    	List<String> res = sol.findWords(board, words);

    	for (String s: res) {
    		System.out.println(s);
    	}
    }
}