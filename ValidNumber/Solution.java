public class Solution {
	public boolean isNumber(String s) {
		//edge cases
		if (s == null || s.length() == 0) {
			return false;
		}
		String trimed = s.trim();
		if (trimed.length() == 0) {
			return false;
		}
		char[] stringArray = trimed.toCharArray();
		boolean eFlag = false;
		boolean pFlag = false;

		for (int i = 0; i < stringArray.length; i++) {
			switch (stringArray[i]) {
				case '.':
					if (eFlag || pFlag || ((i == stringArray.length - 1 || !(stringArray[i + 1] >= '0' && stringArray[i + 1] <= '9')) 
						&& (i == 0 || !(stringArray[i - 1] >= '0' && stringArray[i - 1] <= '9')))) {
						return false;
					}
					pFlag = true;
					break;
				case 'e':
				case 'E':
					if (eFlag || (i == 0) || (i == stringArray.length - 1)) {
						return false;
					}
					eFlag = true;
					break;
				case '-':
				case '+':
					if ((i > 0 && ((stringArray[i - 1] != 'e') && (stringArray[i - 1] != 'E'))) || (i == stringArray.length - 1 || !((stringArray[i + 1] >= '0' && stringArray[i + 1] <= '9') || stringArray[i + 1] == '.'))) {
						return false;
					}
					break;
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
					break;
				default:
					return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		boolean r = s.isNumber("+.8");
		System.out.println(r);
	}

}