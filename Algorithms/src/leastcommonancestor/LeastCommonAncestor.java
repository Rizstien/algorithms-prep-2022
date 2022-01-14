package leastcommonancestor;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
		left = null;
		right = null;
	}
}

public class LeastCommonAncestor {

	public int lca(TreeNode A, int B, int C) {
        if(!find(A,B) || !find(A,C)) return -1;
        TreeNode result = lca_util(A,B,C);
        return result!=null?result.val : -1;

    }

    public TreeNode lca_util(TreeNode A, int B, int C) {
        if(A==null || A.val==B || A.val==C) return A;
        TreeNode left = lca_util(A.left,B,C);
        TreeNode right = lca_util(A.right,B,C);
        if(left!=null && right!=null) return A;
        return left!=null? left : right;
        
    }

    public boolean find(TreeNode A, int val){
        if(A==null) return false;
        return (A.val==val || find(A.left,val) || find(A.right,val));
    }

	public static void main(String[] args) {
		TreeNode nodeA = new TreeNode(3);
		nodeA.left = new TreeNode(5);
		nodeA.right = new TreeNode(1);

		nodeA.left.left = new TreeNode(6);
		nodeA.left.right = new TreeNode(2);

		nodeA.right.left = new TreeNode(0);
		nodeA.right.right = new TreeNode(8);

		nodeA.left.right.left = new TreeNode(7);
		nodeA.left.right.right = new TreeNode(4);

		
		nodeA.left.right.right.left = new TreeNode(42); nodeA.left.right.right.right = new TreeNode(38);
		  
		nodeA.left.right.right.left.left = new TreeNode(47);
		nodeA.left.right.right.left.right = new TreeNode(30);
		  
		nodeA.left.right.right.left.right.left = new TreeNode(27);
		nodeA.left.right.right.left.right.right = new TreeNode(45);
		  
		nodeA.left.right.right.left.right.left.left = new TreeNode(39);
		nodeA.left.right.right.left.right.left.right = new TreeNode(36);
		  
		nodeA.left.right.right.left.right.left.right.right = new TreeNode(24);
		  
		nodeA.left.right.right.left.right.left.right.right.left = new TreeNode(11);
		nodeA.left.right.right.left.right.left.right.right.right = new TreeNode(14);
		  
		nodeA.left.right.right.left.right.left.right.right.left.left = new TreeNode(30); 
		nodeA.left.right.right.left.right.left.right.right.left.right = new TreeNode(2);


		LeastCommonAncestor obj = new LeastCommonAncestor();
		System.out.println(obj.lca(nodeA, 11, 38));

	}

}
