package maxabsdiffrence;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxAbsDiffrence {
	
    public int maxArr(ArrayList<Integer> A) {
        int maxSum = A.get(0), minSum = A.get(0), maxDiff = A.get(0), minDiff = A.get(0);
        
        for(int i=1;i<A.size();i++){
            maxSum = Math.max(maxSum, A.get(i)+i);
            minSum = Math.min(minSum, A.get(i)+i);
            maxDiff = Math.max(maxDiff, A.get(i)-i);
            minDiff = Math.min(minDiff, A.get(i)-i);
        }

        return Math.max(maxSum-minSum, maxDiff-minDiff);
    }
	

	public static void main(String[] args) {
		Integer[] array = { 1, 3, -1 };
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(array));
		
		MaxAbsDiffrence obj = new MaxAbsDiffrence();
		System.out.println(obj.maxArr(A));

	}

}
