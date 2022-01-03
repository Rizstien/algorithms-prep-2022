package foursum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FourSum {
	
	public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Collections.sort(A);

        for(int i=0; i<A.size()-3; i++){
            for(int j=i+1; j<A.size()-2; j++){
                int start = j+1;
                int end = A.size()-1;
                int diff = B-A.get(i)-A.get(j);
                while(start<end){
                    if(A.get(start)+A.get(end)==diff){
                        ArrayList<Integer> innerR = new ArrayList<Integer>();
                        innerR.add(A.get(i));
                        innerR.add(A.get(j));
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
        }

        return result;
    }

	public static void main(String[] args) {
		Integer[] array = { 1, 0, -1, 0, -2, 2 };
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(array));
		int B = 0;

		FourSum obj = new FourSum();
		obj.fourSum(A, B).forEach(e->System.out.println(e+" "));

	}

}
