package sorting.insertionsort;

import java.util.ArrayList;

public class InsertionSort {
	
	public ArrayList<Integer> sort(ArrayList<Integer> arr) {
		int k;
		for(int i=1; i<arr.size(); i++) {
			for(int j=i; j>0; j--) {
				if(arr.get(j-1) > arr.get(j)) {
					k = arr.get(j);
					arr.set(j, arr.get(j-1));
					arr.set(j-1, k);
				}
			}
		}
		
		return arr;
	}
	

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(25);
		arr.add(17);
		arr.add(31);
		arr.add(13);
		arr.add(2);
		
		InsertionSort obj =  new InsertionSort();
		arr = obj.sort(arr);
		
		for(int i=0; i<arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}

}
