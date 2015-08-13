import java.util.*;

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