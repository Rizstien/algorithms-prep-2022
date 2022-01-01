package sorting.bubblesort;

import java.util.ArrayList;

public class BubbleSort {
	
	public ArrayList<Integer> sort(ArrayList<Integer> arr) {
		int k;
		for(int i=0; i<arr.size(); i++) {
			for(int j=0; j<arr.size()-i-1; j++) {
				if(arr.get(j) > arr.get(j+1)) {
					k = arr.get(j+1);
					arr.set(j+1, arr.get(j));
					arr.set(j, k);
				}
			}
		}
		
		return arr;
	}
	

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(14);
		arr.add(33);
		arr.add(27);
		arr.add(35);
		arr.add(10);
		
		BubbleSort obj =  new BubbleSort();
		arr = obj.sort(arr);
		
		for(int i=0; i<arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}

}
