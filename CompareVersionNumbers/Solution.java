public class Solution {
    public int compareVersion(String version1, String version2) {
        if (version1 == null || version2 == null || version1.length() == 0 || version2.length() == 0) {
        	return 0;
        }

        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");

        int length1 = arr1.length;
        int length2 = arr2.length;

        if (length1 > length2) {
        	String[] extended1 = new String[length1];
        	String[] extended2 = new String[length1];

        	for (int i = 0; i < length1; i++) {
        		extended1[i] = arr1[i];
        		extended2[i] = i < length2 ? arr2[i] : "0";
        	}

	    	for (int i = 0; i < length1; i++) {
	    		if (Integer.parseInt(extended1[i]) > Integer.parseInt(extended2[i])) {
	    			return 1;
	    		}
	    		if (Integer.parseInt(extended1[i]) < Integer.parseInt(extended2[i])) {
	    			return -1;
	    		}
	    	}

        } else if (length1 <= length2) {
        	String[] extended1 = new String[length2];
        	String[] extended2 = new String[length2];

        	for (int i = 0; i < length2; i++) {
        		extended2[i] = arr2[i];
        		extended1[i] = i < length1 ? arr1[i] : "0";
        	}

	    	for (int i = 0; i < length2; i++) {
	    		if (Integer.parseInt(extended1[i]) > Integer.parseInt(extended2[i])) {
	    			return 1;
	    		}
	    		if (Integer.parseInt(extended1[i]) < Integer.parseInt(extended2[i])) {
	    			return -1;
	    		}
	    	}
        }


    	return 0;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.compareVersion("1", "1.1"));
    }
}