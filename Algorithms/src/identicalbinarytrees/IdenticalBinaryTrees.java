package identicalbinarytrees;

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

public class IdenticalBinaryTrees {
	
    public int isSameTree(TreeNode A, TreeNode B) {
        if(A==null && B==null) return 1;
        if(A!=null && B==null || A==null && B!=null) return 0;
        if(A.val==B.val){
            return isSameTree(A.left, B.left) & isSameTree(A.right, B.right);
        }
        return 0;
    }

	public static void main(String[] args) {
		TreeNode nodeA = new TreeNode(1);
		nodeA.left = new TreeNode(2);
		nodeA.right = new TreeNode(3);
		nodeA.left.left = new TreeNode(4);
		nodeA.right.left = new TreeNode(5);
		nodeA.right.right = new TreeNode(6);
		
		TreeNode nodeB = new TreeNode(1);
		nodeB.left = new TreeNode(3);
		nodeB.right = new TreeNode(3);
		nodeB.left.left = new TreeNode(4);
		nodeB.right.left = new TreeNode(5);
		nodeB.right.right = new TreeNode(6);
		
		IdenticalBinaryTrees obj = new IdenticalBinaryTrees();
		System.out.println(obj.isSameTree(nodeA, nodeB));

	}

}
