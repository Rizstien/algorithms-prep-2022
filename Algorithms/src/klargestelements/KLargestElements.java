package klargestelements;

import java.util.ArrayList;
import java.util.Arrays;

public class KLargestElements {
	
	public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int n = A.size();
        A = sort(A);
        for(int i=n-1;i>=n-B;i--){
            result.add(A.get(i));
        }
        return result;
    }

    public ArrayList<Integer> sort(ArrayList<Integer> A){
        int n = A.size();

        for(int i = n/2-1;i>=0;i--){
            heapify(A,n,i);
        }

        for(int i=n-1; i>=0;i--){
            int temp = A.get(0);
            A.set(0,A.get(i));
            A.set(i,temp);
            heapify(A,i,0);
        }

        return A;
    }

    public void heapify(ArrayList<Integer> A, int n, int i){
        int largest = i;
        int left_child = 2*i+1;
        int right_child = 2*i+2;

        if(left_child<n && A.get(left_child)>A.get(largest))
            largest = left_child;

        if(right_child<n && A.get(right_child)>A.get(largest))
            largest = right_child;

        if(largest!=i){
            int temp = A.get(i);
            A.set(i,A.get(largest));
            A.set(largest,temp);
            heapify(A,n,largest);
        }
    }

	public static void main(String[] args) {
		Integer[] array = { 22, 21, 3, 25, 26, 7};
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(array));

		KLargestElements obj = new KLargestElements();
		obj.solve(A,3).forEach(e-> System.out.print(e+" "));

	}

}
