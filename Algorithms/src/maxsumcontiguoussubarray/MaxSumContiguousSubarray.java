package maxsumcontiguoussubarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSumContiguousSubarray {

	public int maxSubArray(final List<Integer> A) {
        int maxSum=A.get(0), sum=A.get(0);
        for(int i=1;i<A.size();i++){
            sum = Math.max(sum+A.get(i), A.get(i));
            maxSum = Math.max(sum,maxSum);
        }
        return maxSum;
    }
	
	public static void main(String[] args) {
		Integer[] array = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(array));
		
		MaxSumContiguousSubarray obj = new MaxSumContiguousSubarray();
		obj.maxSubArray(A);

		System.out.println(obj.maxSubArray(A)); 

	}

}
