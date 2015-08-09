package leetcode;

import java.util.*;

public class InsertInterval {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<Interval>();
        //edge cases
        if (newInterval == null) {
        	return intervals;
        }
        if (intervals == null || intervals.size() == 0) {
        	res.add(newInterval);
        	return res;
        }

        //use same method will exceed memory limitation
        for (Interval inter: intervals) {
        	if (inter.end < newInterval.start) {
        		res.add(inter);
        	} else if (newInterval.end < inter.start) {
        		res.add(newInterval);  //think about this, this is the only case insert into middle
        		newInterval = inter;
        	} else if (newInterval.start <= inter.end || newInterval.end >= inter.start) {
        		newInterval = new Interval(Math.min(inter.start, newInterval.start), Math.max(newInterval.end, inter.end));
        	}
        }
        

        res.add(newInterval);
        
        return res;
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
