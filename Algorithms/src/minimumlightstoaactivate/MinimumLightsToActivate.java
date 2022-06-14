package minimumlightstoaactivate;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimumLightsToActivate {

    public static void main(String[] args) {
        Integer[] array = {0,0,1, 1, 1,0,0, 1};
        ArrayList<Integer> A = new ArrayList(Arrays.asList(array));

        MinimumLightsToActivate obj = new MinimumLightsToActivate();
        System.out.println(obj.solve(A, 3));

    }

    public int solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        int count = 0;
        for(int i=0; i<n; i++){
            int l = Integer.max(0,i-B+1);
            int r = Integer.min(n-1,i+B-1);
            boolean isFused = true;
            while(l<=r){
                if(A.get(r) == 1){
                    isFused = false;
                    break;
                }
                r--;
            }

            if(isFused) return -1;
            count++;
            i=r+B;

        }
        return count;
    }

}
