package knapsackproblem;

import java.util.ArrayList;
import java.util.Arrays;

public class KnapsackProblem {
	int dp[][];
	public int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
		int n = A.size();
		dp = new int[C+1][n+1];
		
		for(int row[] : dp) Arrays.fill(row, -1);
		
		return knapSack(A,B,C,n);
	}
	
	int knapSack(ArrayList<Integer> A, ArrayList<Integer> B, int W, int n) {
		if(n==0 || W==0) return 0;
		if(dp[W][n]!=-1) return dp[W][n];
		
		if(B.get(n-1)>W) {
			return dp[W][n] = knapSack(A,B,W,n-1);
		}else {
			return dp[W][n] = Math.max(knapSack(A,B,W,n-1), A.get(n-1)+knapSack(A,B,W-B.get(n-1),n-1));
		}
		
	}

	public static void main(String[] args) {
		Integer[] arrayA = { 60, 100, 120};
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(arrayA));
		
		Integer[] arrayB = { 10, 20, 30};
		ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(arrayB));
		
		int C = 50;
		
		KnapsackProblem obj = new KnapsackProblem();
		System.out.println(obj.solve(A,B,C));

	}

}
