package formlargestnumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FormLargestNumber {
	
	public String largestNumber(final List<Integer> A) {

        ArrayList<String> arr = new ArrayList<String>();

        for(int i=0; i<A.size(); i++){
            arr.add(Integer.toString(A.get(i)));
        }

        Collections.sort(arr, (x, y) -> {
            String XY = x+y;
            String YX = y+x;
            return YX.compareTo(XY);
        });

        StringBuilder strBldr = new StringBuilder();
        for(int i=0; i<arr.size(); i++){
            strBldr.append(arr.get(i));
        }

        int i=0;
        while(i<strBldr.length()-1){
            if(strBldr.charAt(i)=='0'){
                i++;
            }else{
                break;
            }
        }

        if(i>0){
            strBldr.delete(0,i);
        }

        if(strBldr.length()==0) return "0";

        return strBldr.toString();

    }

	public static void main(String[] args) {
		Integer[] array = { 2589, 3, 30, 34, 5, 9, 0 };
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(array));

		FormLargestNumber obj = new FormLargestNumber();
		System.out.println(obj.largestNumber(A));

	}

}
