public class Solution {
	public String addBinary(String a, String b) {
		//edge cases
		if (a == null || b == null) {
			return null;
		}
		if (a.length() == 0) {
			return b;
		}
		if (b.length() == 0) {
			return a;
		}

		int aLen = a.length() - 1;
		int bLen = b.length() - 1;
		int flag = 0;

		StringBuilder sb = new StringBuilder();

		while (aLen >= 0 || bLen >= 0) {
			int aVal = 0;
			int bVal = 0;
			if (aLen >= 0) {
				aVal = a.charAt(aLen) == '0' ? 0 : 1;
				aLen--;
			}
			if (bLen >= 0) {
				bVal = b.charAt(bLen) == '0' ? 0 : 1;
				bLen--;
			}

			int sum = flag + aVal + bVal;
			if (sum >= 2) {
				flag = 1;
				int num = sum % 2;
				sb.append(num);
			} else {
				flag = 0;
				sb.append(sum);
			}
		}

		if (flag == 1) {
			sb.append(1);
		}

		return sb.reverse().toString();

	}

	public static void main(String[] args) {
		Solution s = new Solution();
		String r = s.addBinary("11", "1");
		System.out.println(r);
	}
}