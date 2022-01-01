package sorting.quicksort;

import java.util.ArrayList;

public class QuickSort {
	
	public int partition(ArrayList<Integer> arr, int start, int end) {
		int i = start-1;
		int pivot = arr.get(end);
		for(int j = start; j<end; j++) {
			if(arr.get(j) < pivot) {
				i++;
				
				int temp = arr.get(i);
				arr.set(i, arr.get(j));
				arr.set(j, temp);
			}
		}
		
		int temp = arr.get(i+1);
		arr.set(i+1, pivot);
		arr.set(end, temp);
		
		return i+1;
	}
	
	public ArrayList<Integer> sort(ArrayList<Integer> arr, int start, int end) {
		
		if(start < end) {
			int pi = partition(arr, start, end);
			sort(arr, start, pi-1);
			sort(arr, pi+1, end);
		}
		
		return arr;
	}
	

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(50);
		arr.add(23);
		arr.add(9);
		arr.add(18);
		arr.add(61);
		arr.add(32);
		
		QuickSort obj =  new QuickSort();
		arr = obj.sort(arr, 0, arr.size()-1);
		
		for(int i=0; i<arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}

}
