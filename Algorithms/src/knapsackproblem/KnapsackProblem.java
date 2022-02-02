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
		//Base Case
		if(n==0 || W==0) return 0;
		if(dp[W][n]!=-1) return dp[W][n];
		
		// Can not add item to knapsack as its weight is heavier than total allowed weight
		if(B.get(n-1)>W) {
			// so solve for remaining items
			return dp[W][n] = knapSack(A,B,W,n-1);
		}else {
			// If the item qualify to be added in knapsack
			return dp[W][n] = Math.max(
					// Take it or leave it case
					knapSack(A,B,W,n-1), // Can be added but we choose to Leave it so solve for remaining items
					A.get(n-1)+knapSack(A,B,W-B.get(n-1),n-1)); // Take it, so add its value and solve for remaining items and allowed weight is now less by weight of item added
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
