package sorting.selectionsort;

import java.util.ArrayList;

public class SelectionSort {
	
	public int findMinIndex(ArrayList<Integer> arr, int start) {
		int minIndex = start;
		start++;
		
		while(start < arr.size()) {
			if(arr.get(start) < arr.get(minIndex)) {
				minIndex = start;
			}
			start++;
		}
		
		return minIndex;
	}
	
	public void swap(ArrayList<Integer> arr, int i, int j) {
		int temp = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, temp);
	}
	
	public ArrayList<Integer> sort(ArrayList<Integer> arr) {
		
		for(int i=0; i<arr.size(); i++) {
			int minIndex = findMinIndex(arr, i);
			
			if(i != minIndex) {
				swap(arr, i, minIndex);
			}
		}
		
		return arr;
	}
	

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(5);
		arr.add(2);
		arr.add(6);
		arr.add(7);
		arr.add(2);
		arr.add(1);
		arr.add(0);
		arr.add(3);
		
		SelectionSort obj =  new SelectionSort();
		arr = obj.sort(arr);
		
		for(int i=0; i<arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}

}
