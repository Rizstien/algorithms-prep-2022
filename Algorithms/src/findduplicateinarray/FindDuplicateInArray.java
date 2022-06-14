package findduplicateinarray;

import minimumlightstoaactivate.MinimumLightsToActivate;

import java.util.*;

public class FindDuplicateInArray {

    public static void main(String[] args) {
        Integer[] array = {3,4,1,4,1};
        ArrayList<Integer> A = new ArrayList(Arrays.asList(array));

        FindDuplicateInArray obj = new FindDuplicateInArray();
        System.out.println(obj.repeatedNumber(A));

    }

    public int repeatedNumber(final List<Integer> A) {
        Set<Integer> set = new HashSet<Integer>();

        for(int n : A){
            if(set.contains(n)) return n;
            else set.add(n);
        }
        return -1;
    }
}
