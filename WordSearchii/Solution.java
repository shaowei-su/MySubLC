import java.util.*;

public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<String>();
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
            return res;
        }
        int row = board.length;
        int col = board[0].length;
        for (int w = 0; w < words.length; w++) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (findHelper(board, words[w], i, j, 0)) {
                        res.add(words[w]);
                    }
                }
            }
        }

        return res;
    }

    public boolean findHelper(char[][] board, String word, int i, int j, int pos) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        if (board[i][j] == word.charAt(pos)) {
            if (pos == word.length() - 1) {
                return true;
            }
            char temp = board[i][j];
            board[i][j] = '#';
            if (findHelper(board, word, i + 1, j, pos + 1) ||
                    findHelper(board, word, i - 1, j, pos + 1) ||
                    findHelper(board, word, i, j + 1, pos + 1) ||
                    findHelper(board, word, i, j - 1, pos + 1)) {
                board[i][j] = temp;
                return true;
            }
            board[i][j] = temp;
        }

        return false;
    }
}
