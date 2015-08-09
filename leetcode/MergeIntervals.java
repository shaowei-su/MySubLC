package leetcode;

import java.util.*;

class IntervalComparator implements Comparator<Interval> {
	public int compare(Interval i1, Interval i2) {
		return i1.start - i2.start;
	}
}

public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        //edge cases
    	if (intervals == null || intervals.size() <= 1) {
    		return intervals;
    	}
    	
    	//sort the inpurt intervals list
    	Collections.sort(intervals, new IntervalComparator());
    	
    	List<Interval> res = new ArrayList<Interval>();
    	Interval prev = intervals.get(0);
    	for (int i = 1; i < intervals.size(); i++) {
    		Interval cur = intervals.get(i);
    		if (prev.end >= cur.start) {
    			Interval merged = new Interval(prev.start, Math.max(prev.end, cur.end));
    			prev = merged;
    		} else {
    			res.add(prev);
    			prev = cur;
    		}
    	}
    	
    	res.add(prev);
    	
    	return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
