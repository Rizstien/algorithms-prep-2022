package arrayrotation;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayRotation {
	
	public ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {

		while(B>A.size()){
			B = B-A.size();
		}

		ArrayList<Integer> ret = new ArrayList<Integer>();
		for (int i = 0; i < A.size(); i++) {
			if((i+B)<A.size()){
				ret.add(A.get(i + B));
			}
		}

		for (int i = 0; i < B; i++) {
			ret.add(A.get(i));
		}

		return ret;
	}

	public static void main(String[] args) {
		
		Integer[] array = {14, 5, 14, 34, 42, 63, 17, 25, 39, 61, 97, 55, 33, 96, 62, 32, 98, 77, 35};
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(array));

		ArrayRotation obj =  new ArrayRotation();
		arr = obj.rotateArray(arr, 56);
		
		for(int i=0; i<arr.size(); i++) {
			System.out.println(arr.get(i));
		}

	}

}
