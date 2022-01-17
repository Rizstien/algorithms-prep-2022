package distinctnumbersinwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class DistinctNumbersInWindow {

	public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Map<Integer, Integer> set = new HashMap<Integer, Integer>();
        if(B>A.size()) return result;
        Queue<Integer> queue = new LinkedList<Integer>();
        int j=0;
        
        for(int i=0; i<=A.size()-B;i++){
        	if(!queue.isEmpty()) {
        		result.add(set.size());
        		removeElement(set,queue.remove());
            	queue.add(A.get(i+j-1));
            	addElement(set,A.get(i+j-1));
        	}
        	
        	if(queue.isEmpty()) {
                while(j<B){
                	queue.add(A.get(i+j));
                	addElement(set,A.get(i+j));
                    j++;
                }
        	}
        }
        
    	if(!queue.isEmpty()) {
    		result.add(set.size());
        	set.clear();
    	}
        
        return result;
    }
	
	public void addElement(Map<Integer, Integer> set, Integer val) {
		if(!set.containsKey(val)) {
			set.put(val, 1);
		}else {
			set.put(val, set.get(val)+1);
		}
	}
	
	public void removeElement(Map<Integer, Integer> set, Integer val) {
		if(set.get(val)==1) {
			set.remove(val);
		}else {
			set.put(val, set.get(val)-1);
		}
	}
	
	public static void main(String[] args) {
		Integer[] array = { 1, 2, 1, 3, 4, 3 };
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(array));

		DistinctNumbersInWindow obj = new DistinctNumbersInWindow();
		obj.dNums(A,3).forEach(e-> System.out.print(e+" "));

	}

}
