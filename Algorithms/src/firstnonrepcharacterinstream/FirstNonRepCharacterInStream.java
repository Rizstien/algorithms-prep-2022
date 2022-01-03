package firstnonrepcharacterinstream;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepCharacterInStream {
	
	public String solve(String A) {
        Queue<Character> window = new LinkedList<Character>();
        char[] charArray = A.toCharArray();
        int[] freq  = new int[26];

        StringBuilder strBldr = new StringBuilder();
        for(int i=0; i<charArray.length; i++){
        	freq[charArray[i]-'a']++;
        	if(window.isEmpty()) {
        		if(freq[charArray[i]-'a']==1) {
        			strBldr.append(charArray[i]);
        			window.offer(charArray[i]);
        		}
        		else strBldr.append("#");
        	}else {
        		if(freq[charArray[i]-'a']==1) {
        			window.offer(charArray[i]);
        		}
        		strBldr.append(firstUnique(freq, window));
        	}

        }
        return strBldr.toString();
    }
	
	public char firstUnique(int[] freq, Queue<Character> window) {
		while(!window.isEmpty() && freq[window.peek()-'a']>1) window.poll();
		return window.isEmpty()?'#': window.peek();
	}
	
	public static void main(String[] args) {
		FirstNonRepCharacterInStream obj = new FirstNonRepCharacterInStream();
		System.out.print(obj.solve("abcabc"));
	}

}
