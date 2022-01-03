package anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Anagrams {
	
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Set<String> set = new HashSet<String>();
        Set<Integer> index = new HashSet<Integer>();
        for(int i=0; i<A.size(); i++){
            if(!index.contains(i+1)){
                set.add(sort(A.get(i)));
                ArrayList<Integer> innerR = new ArrayList<Integer>();
                innerR.add(i+1);
                index.add(i+1);
                for(int j=i+1; j<A.size(); j++){
                    if(set.contains(sort(A.get(j))) && !index.contains(j+1)){
                        innerR.add(j+1);
                        index.add(j+1);
                    }
                }
                result.add(innerR);
            }
        }
        return result;
    }

    public String sort(String str){
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }

	public static void main(String[] args) {
		String[] array = { "cat", "dog", "god", "tca"};
		ArrayList<String> A = new ArrayList<String>(Arrays.asList(array));

		Anagrams obj = new Anagrams();
		obj.anagrams(A).forEach(e->System.out.println(e+" "));

	}

}
