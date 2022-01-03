package slidingwindowmaximum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMaximum {

	public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        if(B>=A.size()){
            int max = A.get(0);
            for(int i=0; i<A.size();i++){
                max = Math.max(max,A.get(i));
            }
            result.add(max);
            return result;
        } 

        Deque<Integer> window = new LinkedList<Integer>();
        for(int i=0; i<=A.size()-B;i++){
        	for(int j=0;j<B;j++) {
        		if(window.isEmpty()) {
        			window.addFirst(A.get(i+j));
        		}else if(A.get(i+j)>=window.peekFirst()){
                    window.addFirst(A.get(i+j));
                    window.removeLast();
                }
        	}
        	result.add(window.removeFirst());
        	//window.clear();
        }
        return result;
    }

	
	public static void main(String[] args) {
		//Integer[] array = { 1, 3, -1, -3, 5, 3, 6, 7};
		Integer[] array = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(array));

		SlidingWindowMaximum obj = new SlidingWindowMaximum();
		A=obj.slidingMaximum(A, 2);
		A.forEach(e->System.out.print(e+" "));

	}

}
