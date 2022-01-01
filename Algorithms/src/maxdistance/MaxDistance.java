package maxdistance;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxDistance {
	
    public int maximumGap(final List<Integer> a) {
	    int size = a.size();
	    ArrayDeque<Integer> A = new ArrayDeque<Integer>();	    
	    
	    for(int i=0; i<size; i++) {
	    	if(A.isEmpty() || a.get(A.peekLast()) >= a.get(i)) {
	    		A.add(i);
	    	}
	    }
	    
	    int maxDis = 0;
	    for(int i=size-1; i>=0; i--) {
	    	while(!A.isEmpty() && a.get(i) >= a.get(A.peekLast())) {
	    		maxDis = Math.max(maxDis, i-A.pollLast());
	    	}
	    }
	    
	    return maxDis;
	    
	}

	public static void main(String[] args) {
		Integer[] array = { 3, 5, 4, 2 };
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(array));

		MaxDistance obj = new MaxDistance();
		System.out.println(obj.maximumGap(A));

	}

}
