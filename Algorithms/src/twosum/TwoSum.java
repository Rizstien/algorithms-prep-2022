package twosum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TwoSum {
	
	public ArrayList<Integer> twoSum(final List<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<A.size(); i++){
            if(map.containsKey(B-A.get(i))){
                result.add(map.get(B-A.get(i)));
                result.add(i+1);
                return result;
            }else if(!map.containsKey(A.get(i))){
                map.put(A.get(i), i+1);
            }
        }
        return result;
    }
	
	public static void main(String[] args) {
		Integer[] array = { 4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8 };
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(array));
		int B = -3;

		TwoSum obj = new TwoSum();
		obj.twoSum(A, B).forEach(e->System.out.print(e+" "));

	}

}
