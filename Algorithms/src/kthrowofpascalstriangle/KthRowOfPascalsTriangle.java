package kthrowofpascalstriangle;

import minimumlightstoaactivate.MinimumLightsToActivate;

import java.util.ArrayList;
import java.util.Arrays;

public class KthRowOfPascalsTriangle {

    public static void main(String[] args) {
        KthRowOfPascalsTriangle obj = new KthRowOfPascalsTriangle();
        obj.getRow(4).forEach(e-> System.out.print(e+" "));
    }

    public ArrayList<Integer> getRow(int A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> pascal = new ArrayList<ArrayList<Integer>>();

        if(A==0){
            result.add(1);
            return result;
        }else if(A==1){
            result.add(1);
            result.add(1);
            return result;
        }

        for(int i=0; i<=A; i++){
            result = new ArrayList<>();
            if(i==0){
                result.add(1);
                pascal.add(result);
                continue;
            }else if(i==1){
                result.add(1);
                result.add(1);
                pascal.add(result);
                continue;
            }

            result.add(1);
            for(int j=1;j<i;j++){
                result.add(pascal.get(i-1).get(j)+pascal.get(i-1).get(j-1));
            }
            result.add(1);
            pascal.add(result);
        }

        return pascal.get(pascal.size()-1);
    }


}
