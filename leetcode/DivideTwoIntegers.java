package leetcode;

public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
    	//edge cases
        if (divisor == 0) return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return  Integer.MAX_VALUE;
        //convert to long 
        long dvd = Math.abs((long)dividend); //eliminate the influence of negative numbers !!!!
        long dvs = Math.abs((long)divisor);
        int res = 0;
        while (dvd >= dvs) {
        	int count = 0;
        	while (dvd >= (dvs << count)) {
        		count++;
        	}
        	dvd -= dvs << (count - 1);
        	res += 1 << (count - 1);
        }
        
        if (dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0) {
        	return res;
        } else {
        	return -res;
        }
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DivideTwoIntegers d = new DivideTwoIntegers();
		int r = d.divide(2, 2);
		System.out.println(r);
	}

}
