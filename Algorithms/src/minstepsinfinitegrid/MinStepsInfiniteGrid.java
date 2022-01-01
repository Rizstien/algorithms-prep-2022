package minstepsinfinitegrid;

import java.util.ArrayList;
import java.util.Arrays;

public class MinStepsInfiniteGrid {

    public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        int currX, nextX;
        int currY, nextY;
        int totalSteps = 0, steps=0;
        if(A.size()!=B.size()){return -1;}
        if(A.size()==1){return 0;}

        for(int i=0; i<A.size()-1; i++){
            steps=0;
            currX = A.get(i);
            currY = B.get(i);

            nextX = A.get(i+1);
            nextY = B.get(i+1);

            steps = Math.max(Math.abs(nextX-currX), Math.abs(nextY-currY));
            totalSteps+=steps;
        }

        return totalSteps;

    }

	public static void main(String[] args) {
		Integer[] array = { 0, 1, 1 };
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(array));

		array[0] = 0;
		array[1] = 1;
		array[2] = 2;
		ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(array));

		MinStepsInfiniteGrid obj = new MinStepsInfiniteGrid();
		System.out.println(obj.coverPoints(A, B));
		 
	}

}
