import java.util.*;

public class Solution {
	public List<String> fullJustify(String[] words, int maxWidth) {
		//edge cases
		if (words == null || words.length == 0) {
			return null;
		}

		ArrayList<String> res = new ArrayList<String>();

		int count = 0;
		int last = 0;

		for (int i = 0; i < words.length; i++) {
			if (count + words[i].length() + i - last > maxWidth) {
				StringBuilder sb = new StringBuilder();
				if (i - last - 1 > 0) {
					int emptyLength = (maxWidth - count) / (i - last - 1);
					int extraEmpty = (maxWidth - count) % (i - last - 1);

					for (int j = last; j < i - 1; j++) {
						sb.append(words[j]);
						for (int k = 0; k < emptyLength; k++) {
							sb.append(" ");
						}
						if (extraEmpty > 0) {
							sb.append(" ");
						}
						extraEmpty--;
					}
				}

				sb.append(words[i - 1]);
				for (int j = sb.length(); j < maxWidth; j++) {
					sb.append(" ");
				}

				res.add(sb.toString());

				last = i;
				count = 0;
			}

			count += words[i].length();

		}
		StringBuilder sb = new StringBuilder();
		for (int i = last; i < words.length - 1; i++) {
			sb.append(words[i]);
			sb.append(" ");
		}
		sb.append(words[words.length - 1]);
		while (sb.length() < maxWidth) {
			sb.append(" ");
		}

		res.add(sb.toString());

		return res;

	}

	public static void main(String[] args) {
		Solution s = new Solution();
		String[] words = {"listen", "to", "many,", "speak", "to", "a", "few."};
		List<String> r = s.fullJustify(words, 6);
		for (String i : r) {
			System.out.println(i + i.length());
		}
	}
}