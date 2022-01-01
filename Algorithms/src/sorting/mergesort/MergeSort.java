package sorting.mergesort;

import java.util.ArrayList;

public class MergeSort {
	
	public ArrayList<Integer> merge(ArrayList<Integer> arr, int start, int mid, int end) {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		
		int i = start, j=mid+1;
		
		while(i<=mid && j<=end) {
			if(arr.get(i) < arr.get(j)) {
				temp.add(arr.get(i));
				i++;
			}else {
				temp.add(arr.get(j));
				j++;
			}
		}
		
		while(i<=mid) {
			temp.add(arr.get(i));
			i++;
		}
		
		while(j<=end) {
			temp.add(arr.get(j));
			j++;
		}
		
		for(int k = start; k<=end; k++) {
			arr.set(k, temp.get(k-start));
		}
		
		return arr;
	}
	
	public ArrayList<Integer> mergeSort(ArrayList<Integer> arr, int start, int end) {
		
		if(start < end) {
			int mid = start+(end-start)/2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid+1, end);
			merge(arr, start, mid, end);
		}
		
		return arr;
	}
	

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(14);
		arr.add(7);
		arr.add(3);
		arr.add(12);
		arr.add(9);
		arr.add(11);
		arr.add(6);
		arr.add(2);
		
		MergeSort obj =  new MergeSort();
		arr = obj.mergeSort(arr, 0, arr.size()-1);
		
		for(int i=0; i<arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}

}
