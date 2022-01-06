package threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ThreeSum {
	
	public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Collections.sort(A);

        for(int i=0; i<A.size()-1; i++){
            int start = i+1;
            int end = A.size()-1;
            int diff = B-A.get(i);
            while(start<end){
                if(A.get(start)+A.get(end)==diff){
                    ArrayList<Integer> innerR = new ArrayList<Integer>();
                    innerR.add(A.get(i));
                    innerR.add(A.get(start));
                    innerR.add(A.get(end));
                    if(!result.contains(innerR)) result.add(innerR);
                    start++;
                    end--;
                }else if(A.get(start)+A.get(end)>diff){
                    end--;
                }else{
                    start++;
                }
            }
        }

        return result;
    }

	public static void main(String[] args) {
		Integer[] array = { -3, 2, 0, -5, 1, 5 };
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(array));
		int B = 0;

		ThreeSum obj = new ThreeSum();
		obj.threeSum(A, B).forEach(e->System.out.println(e+" "));

	}

}
