package nextpermutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NextPermutation {

	public ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {
        int i = findConDecSeqBfrIndex(A);

        if(i==0){
            Collections.reverse(A);
            return A;   
        }

        int j = findConDecSeqAfterIndex(A, i);

        Collections.swap(A,i,j);
        Collections.reverse(A.subList(i+1,A.size()));
        return A;
    }

    public int findConDecSeqBfrIndex(ArrayList<Integer> A){
        int indexI=0;
        for(int i=0;i<A.size()-1; i++){
            if(A.get(i)<A.get(i+1)) indexI = i;
        }
        return indexI;
    }

    public int findConDecSeqAfterIndex(ArrayList<Integer> A, int I){
        int indexJ=0;
        for(int j=I+1;j<A.size(); j++){
            if(A.get(j)>A.get(I)) indexJ = j;
        }
        return indexJ;
    }
	
	public static void main(String[] args) {
		Integer[] array = { 1, 2, 4, 3, 5 };
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(array));

		NextPermutation obj = new NextPermutation();
		A=obj.nextPermutation(A);
		A.forEach(e->System.out.print(e+" "));

	}

}
