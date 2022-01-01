package validparenthesesstack;

import java.util.Stack;

public class ValidParenthesesStack {

	public int isValid(String A) {
        Stack<Character> stack = new Stack<Character>();
        char[] arr = A.toCharArray();

        for(int i = 0; i<arr.length; i++){
            if(arr[i]=='(' || arr[i]=='{' || arr[i]=='['){
                stack.push(arr[i]);
            }else if(arr[i]==')'){
            	if(!stack.isEmpty() && stack.peek()=='(') {
            		stack.pop();
            	}else {
            		return 0;
            	}
            }else if(arr[i]=='}'){
            	if(!stack.isEmpty() && stack.peek()=='{') {
            		stack.pop();
            	}else {
            		return 0;
            	}
            }else if(arr[i]==']'){
            	if(!stack.isEmpty() && stack.peek()=='[') {
            		stack.pop();
            	}else {
            		return 0;
            	}
            }
        }

        if(stack.isEmpty()) return 1;
        else return 0;
    }
	
	public static void main(String[] args) {
		//String A = "((((([{()}[]]]{{{[]}}})))))";
		String A = "])";
		
		ValidParenthesesStack obj = new ValidParenthesesStack();
		System.out.println(obj.isValid(A));

	}

}
