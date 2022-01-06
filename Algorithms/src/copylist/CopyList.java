package copylist;

import java.util.HashMap;

class RandomListNode {
	int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
}
 
public class CopyList {

	public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode result = null;
        RandomListNode curr = head;
        while(curr!=null){
            map.put(curr, new RandomListNode(curr.label));
            curr = curr.next;
        }
        curr = head;
        while(curr!=null){
            result = map.get(curr);
            result.next = map.get(curr.next);
            result.random = map.get(curr.random);
            curr = curr.next;
            result = result.next;
        }

        return map.get(head);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
