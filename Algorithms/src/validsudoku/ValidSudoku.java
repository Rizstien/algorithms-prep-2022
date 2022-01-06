package validsudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class ValidSudoku {
	
	public int isValidSudoku(final List<String> A) {
        if(A.size()!=9) return 0;
        ArrayList<Integer> arr1 = new ArrayList<Integer>(Collections.nCopies(9, 0));
        ArrayList<Integer> arr2 = new ArrayList<Integer>(Collections.nCopies(9, 0));
        ArrayList<Integer> arr3 = new ArrayList<Integer>(Collections.nCopies(9, 0));
        ArrayList<Integer> arr4 = new ArrayList<Integer>(Collections.nCopies(9, 0));
        ArrayList<Integer> arr5 = new ArrayList<Integer>(Collections.nCopies(9, 0));
        ArrayList<Integer> arr6 = new ArrayList<Integer>(Collections.nCopies(9, 0));
        ArrayList<Integer> arr7 = new ArrayList<Integer>(Collections.nCopies(9, 0));
        ArrayList<Integer> arr8 = new ArrayList<Integer>(Collections.nCopies(9, 0));
        ArrayList<Integer> arr9 = new ArrayList<Integer>(Collections.nCopies(9, 0));
        
        ArrayList<ArrayList<Integer>> soduku = new ArrayList<ArrayList<Integer>>();
        soduku.add(arr1);soduku.add(arr2);soduku.add(arr3);
        soduku.add(arr4);soduku.add(arr5);soduku.add(arr6);
        soduku.add(arr7);soduku.add(arr8);soduku.add(arr9);
        
        HashSet<Integer> set = new HashSet<Integer>();
        
        for(int i=0; i<A.size(); i++){
            String str = A.get(i);
            if(str.length()!=9) return 0;
            for(int j=0; j<str.length(); j++){
                if(str.charAt(j)=='.') soduku.get(i).set(j, null);
                else if(str.charAt(j)=='0') return 0;
                else soduku.get(i).set(j, Character.getNumericValue(str.charAt(j)));
            }
        }

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(set.contains(soduku.get(i).get(j))){
                    return 0;
                }else if(soduku.get(i).get(j)!=null){
                    set.add(soduku.get(i).get(j));
                }
            }
            set.clear();
        }

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(set.contains(soduku.get(j).get(i))){
                    return 0;
                }else if(soduku.get(j).get(i)!=null){
                    set.add(soduku.get(j).get(i));
                }
            }
            set.clear();
        }

        for(int i=0; i<9; i+=3){
            for(int j=0; j<9; j+=3){
                for(int k=i; k<i+3; k++){
                    for(int l=j; l<j+3; l++){
                        if(set.contains(soduku.get(k).get(l))){
                            return 0;
                        }else if(soduku.get(k).get(l)!=null){
                            set.add(soduku.get(k).get(l));
                        }
                    }
                }
                set.clear();
            }
        }
        return 1;
    }
	
	
	public static void main(String[] args) {
		String[] array = { "....5..1.", ".4.3.....", ".....3..1", "8......2.", "..2.7....", ".15......", ".....2...", ".2.9.....", "..4......" };
		ArrayList<String> A = new ArrayList<String>(Arrays.asList(array));

		ValidSudoku obj = new ValidSudoku();
		System.out.print(obj.isValidSudoku(A));
	}

}
