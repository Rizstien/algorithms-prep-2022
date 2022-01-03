package nearestsmallerelement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerElement {
	
	public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();;
        
        for(int i=0;i<A.size(); i++){
            while(!stack.isEmpty() && stack.peek()>=A.get(i)){
                stack.pop();
            }
            if(stack.isEmpty()) result.add(-1);
            else if(stack.peek()<A.get(i)) result.add(stack.peek());
            stack.push(A.get(i));
        }
        return result;
    }

	public static void main(String[] args) {
		Integer[] array = { 39, 27, 11, 4, 24, 32, 32, 1 };
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(array));

		NearestSmallerElement obj = new NearestSmallerElement();
		A=obj.prevSmaller(A);
		A.forEach(e->System.out.print(e+" "));
	}

}
