import java.util.*;
import java.lang.*;

/*
    you must be kidding.
    Time ~ O(N^2), Space ~ O(1) 
    可以用以下规则实现：
    n = 1:     0  |   1
    n = 2:   00    01 | 11   10
    n = 3: 000  001 011 010 | 110 111 101 100
    ...
    红线左边的为上一行序列从左往右每个码前加 0，
    红线右边的为上一行序列从右往左每个码前加 1。
*/
public class Solution {

    public List<Integer> grayCode(int n) {
    	List<Integer> res = new ArrayList<Integer>();
        if (n < 0) {
        	return res;
        }

        res.add(0);
        for (int i = 0; i < n; i++) {
            int flipper = 1 << i; // flipper used to change the i-bit from 0 into 1
            int size = res.size();
            for (int j = size - 1; j >= 0; j--) {
                res.add(res.get(j) | flipper);
            }
        }
        //so basically, what we does is convert greycode(n - 1) to graycode(n)
        //namely, add 1 to all the previous result backward
        return res;
    }
}