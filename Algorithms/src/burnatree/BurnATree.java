package burnatree;

class TreeNode {
	int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int x) {
    	val = x;
    	left=null;
    	right=null;
    }
}

public class BurnATree {
	
	int ans = 0;
    public int solve(TreeNode A, int B) {
        find(A,B);
        return ans-1;
    }

    public int maxHeight(TreeNode A) {
    	if(A==null) return 0;
    	else return Math.max(maxHeight(A.left), maxHeight(A.right))+1;
    }
    
    public int find(TreeNode A, int B) {
    	if(A==null) return -1;
    	if(A.val==B) {
    		ans = maxHeight(A);
    		return ans;
    	}
    	
    	int curr = find(A.left, B);
    	if(curr!=-1) {
    		int h = maxHeight(A.right);
    		ans = Math.max(ans, h+curr+1);
    		return curr+1;
    	}
    	
    	curr = find(A.right, B);
    	if(curr!=-1) {
    		int h = maxHeight(A.left);
    		ans = Math.max(ans, h+curr+1);
    		return curr+1;
    	}
    	
    	return ans;
    }
    
	public static void main(String[] args) {
		TreeNode nodeA = new TreeNode(1);
		nodeA.left = new TreeNode(2);
		nodeA.right = new TreeNode(3);
		
		nodeA.left.left = new TreeNode(4);
		
		nodeA.right.left = new TreeNode(5);
		nodeA.right.right = new TreeNode(6);
		
		BurnATree obj = new BurnATree();
		System.out.println(obj.solve(nodeA, 4));

	}

}
