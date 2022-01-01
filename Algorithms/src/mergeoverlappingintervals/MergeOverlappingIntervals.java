package mergeoverlappingintervals;

import java.util.ArrayList;
import java.util.Collections;

class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}

public class MergeOverlappingIntervals {
	
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> result = new ArrayList<Interval>();

        Collections.sort(intervals, (x,y) -> Integer.compare(x.start, y.start));
        
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        
        for(int i=1; i<intervals.size(); i++){
            if(intervals.get(i).start <= end && intervals.get(i).end >= end) {
                end = intervals.get(i).end;
            }else if(intervals.get(i).start > end) {
                result.add(new Interval(start, end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            }
        }
        result.add(new Interval(start, end));
        return result;
    }


	public static void main(String[] args) {
		ArrayList<Interval> A = new ArrayList<Interval>();
		
		A.add(new Interval(1,3));
		A.add(new Interval(2,6));
		A.add(new Interval(8,10));
		A.add(new Interval(15,18));
		A.add(new Interval(5,9));

		MergeOverlappingIntervals obj = new MergeOverlappingIntervals();
		obj.merge(A).forEach(e-> System.out.print("["+e.start+ ", "+e.end+"], "));
	}

}
