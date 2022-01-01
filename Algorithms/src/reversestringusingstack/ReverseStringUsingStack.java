package reversestringusingstack;

import java.util.Stack;

public class ReverseStringUsingStack {

	public String reverseString(String A) {
        if(A.length()==0) return "";
        Stack<Character> stack = new Stack<Character>();
        char[] charArr = A.toCharArray();
        StringBuilder result = new StringBuilder();
        for(int i = 0; i<charArr.length; i++){
            stack.push(charArr[i]);
        }

        while(!stack.empty()){
            result.append(stack.pop());
        }
        return result.toString();
    }
	
	public static void main(String[] args) {
		String A = "((((([{()}[]]{{{[]}}})))))";
		
		ReverseStringUsingStack obj = new ReverseStringUsingStack();
		System.out.println(obj.reverseString(A));
	}

}
