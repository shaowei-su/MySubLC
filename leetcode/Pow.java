package leetcode;

public class Pow {
	
	public double pow(double x, int n) {
		if (n == 0) return 1;
		double re = pow(x, n / 2);
		if (n % 2 == 0) {
			return re * re;
		} else {
			return re * re * x;
		}
	}
	
    public double myPow(double x, int n) {
    	if (n < 0) {
    		return 1 / pow(x, -n);
    	} else {
    		return pow(x, n);
    	}
    }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pow p = new Pow();
		double res = p.myPow(2.0, 2);
		System.out.println(res);
	}

}
