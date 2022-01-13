package mindepthofbinarytree;

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

public class MinDepthofBinaryTree {
	
	public int minDepth(TreeNode A) {
        if(A==null) return 0;
        if(A.left==null && A.right==null) return 1;
        int leftDepth = minDepth(A.left);
        int rightDepth = minDepth(A.right);
        if(leftDepth!=0 && rightDepth!=0) return Math.min(leftDepth,rightDepth)+1;
        else if(leftDepth==0) return rightDepth+1;
        else return leftDepth+1;
    }

	public static void main(String[] args) {
		TreeNode nodeA = new TreeNode(1);
		nodeA.left = new TreeNode(2);
		nodeA.right = new TreeNode(3);
		nodeA.left.left = new TreeNode(4);
		nodeA.left.right = new TreeNode(5);
		nodeA.right.left = new TreeNode(6);
		nodeA.right.right = new TreeNode(7);
		
		nodeA.right.left.left = new TreeNode(8);
		nodeA.right.right.right = new TreeNode(9);
		
		MinDepthofBinaryTree obj = new MinDepthofBinaryTree();
		System.out.println(obj.minDepth(nodeA));

	}

}
