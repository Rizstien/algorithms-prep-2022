package rotatematrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RotateMatrix {
	
	public void rotate(ArrayList<ArrayList<Integer>> a) {
        transpose(a);
        for(int i=0; i<a.size(); i++){
            Collections.reverse(a.get(i));
        }
	}

	public void transpose(ArrayList<ArrayList<Integer>> a){
        for(int i=0; i<a.size(); i++){
            for(int j=i+1; j<a.get(0).size(); j++){
                int temp = a.get(j).get(i);
                a.get(j).set(i, a.get(i).get(j));
                a.get(i).set(j, temp);
            }
        }
    }
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();

		Integer[] array = { 1, 2, 3 };
		ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(array));
		A.add(a);

		array[0] = 4;
		array[1] = 5;
		array[2] = 6;
		a = new ArrayList<Integer>(Arrays.asList(array));
		A.add(a);

		array[0] = 7;
		array[1] = 8;
		array[2] = 9;
		a = new ArrayList<Integer>(Arrays.asList(array));
		A.add(a);
		
		array[0] = 10;
		array[1] = 11;
		array[2] = 12;
		a = new ArrayList<Integer>(Arrays.asList(array));
		A.add(a);

		RotateMatrix obj = new RotateMatrix();
		obj.rotate(A);

		
		for(int i=0; i<A.size(); i++) { 
			for(int j=0; j<A.get(0).size(); j++) { 
				System.out.println(A.get(i).get(j)); 
			}
		}
	}

}
