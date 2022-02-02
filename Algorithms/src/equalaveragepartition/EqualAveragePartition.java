package equalaveragepartition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class EqualAveragePartition {
	ArrayList<Integer> indexSetA = new ArrayList<Integer>();
	boolean dp[][][];
	int sumA, n;
	ArrayList<Integer> array;

	public ArrayList<ArrayList<Integer>> avgset(ArrayList<Integer> A) {
		Collections.sort(A);
		n = A.size();
		array = A;
		int sum = 0;

		for (int val : A)
			sum += val;
		dp = new boolean[n][sum + 1][n];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < sum + 1; j++)
				for (int k = 0; k < n; k++)
					dp[i][j][k] = true;

		for (int sizeA = 1; sizeA < n; sizeA++) {
			if ((sum * sizeA) % n != 0)
				continue;

			sumA = (sum * sizeA) / n;
			if (isPartitionPossible(0, sumA, sizeA)) {
				break;
			}
		}

		return generatePartitions();
	}

	private boolean isPartitionPossible(int index, int sumA, int sizeA) {
		if (sizeA == 0)
			return sumA == 0;
		if (index >= n)
			return false;
		if (!dp[index][sumA][sizeA])
			return false;

		if (sumA >= array.get(index)) {
			indexSetA.add(index);
			if (isPartitionPossible(index + 1, sumA - array.get(index), sizeA - 1)) {
				return true;
			}
			indexSetA.remove(indexSetA.size() - 1);
		}

		if (isPartitionPossible(index + 1, sumA, sizeA)) {
			return true;
		}

		dp[index][sumA][sizeA] = false;
		return dp[index][sumA][sizeA];
	}

	private ArrayList<ArrayList<Integer>> generatePartitions() {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (indexSetA.size() == 0 || indexSetA.size() == n)
			return result;

		result.add(new ArrayList<Integer>());
		result.add(new ArrayList<Integer>());

		int i = 0, j = 0;
		while (i < n && j < indexSetA.size()) {
			if (i == indexSetA.get(j)) {
				result.get(0).add(array.get(i));
				j++;
			} else {
				result.get(1).add(array.get(i));
			}
			i++;
		}

		while (i < n) {
			result.get(1).add(array.get(i));
			i++;
		}

		return result;
	}

	public static void main(String[] args) {
		Integer[] arrayA = { 1, 7, 15, 29, 11, 9};
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(arrayA));
		
		EqualAveragePartition obj = new EqualAveragePartition();
		obj.avgset(A).forEach(e->System.out.println(e));

	}

}
