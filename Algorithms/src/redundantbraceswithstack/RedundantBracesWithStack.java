package redundantbraceswithstack;

import java.util.Stack;

public class RedundantBracesWithStack {
	
	 public int braces(String A) {
	        Stack<Character> stack = new Stack<Character>();
	        char[] arr = A.toCharArray();

	        for(int i = 0; i<arr.length; i++){
	            if(arr[i]=='(' || arr[i]=='+' || arr[i]=='-' || arr[i]=='*' || arr[i]=='/'){
	                stack.push(arr[i]);
	            }else if(arr[i]==')' && !stack.isEmpty()){
	            	if(stack.peek()=='(') {
	                    return 1;
	            	}else {
	                    char val = 'a';
	            		do{
	                        val = stack.pop();
	                    }while(val!='(');
	            	}
	            }
	        }

	        return 0;
	    }
	
	
	public static void main(String[] args) {
		//String  A = "(a + (a + b))";
		String  A = "((a + b))";
		
		RedundantBracesWithStack obj = new RedundantBracesWithStack();
		System.out.println(obj.braces(A));
	}

}
