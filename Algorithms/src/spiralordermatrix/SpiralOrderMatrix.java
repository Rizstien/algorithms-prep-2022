package spiralordermatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralOrderMatrix {

	boolean[][] visited;
	ArrayList<Integer> result = new ArrayList<Integer>();

	enum Direction {
		FORWARD, BACKWARD, UP, DOWN
	};

	public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {

		if (A.size() == 1) {
			return A.get(0);
		}

		int size = A.get(0).size() * A.size();
		int k = 0;
		Direction dir = Direction.FORWARD;
		int c = 0, r = 0;
		int m = A.size(), n = A.get(0).size();
		visited = new boolean[A.size()][A.get(0).size()];

		while (k < size) {
			if (dir == Direction.FORWARD) {
				if (c < n && !visited[r][c]) {
					result.add(A.get(r).get(c));
					visited[r][c] = true;
					c++;
					k++;
				} else {
					dir = Direction.DOWN;
					c--;
					r++;
				}
			} else if (dir == Direction.DOWN) {
				if (r < m && !visited[r][c]) {
					result.add(A.get(r).get(c));
					visited[r][c] = true;
					r++;
					k++;
				} else {
					dir = Direction.BACKWARD;
					r--;
					c--;
				}
			} else if (dir == Direction.BACKWARD) {
				if (c >= 0 && !visited[r][c]) {
					result.add(A.get(r).get(c));
					visited[r][c] = true;
					c--;
					k++;
				} else {
					dir = Direction.UP;
					c++;
					r--;
				}
			} else if (dir == Direction.UP) {
				if (r >= 0 && !visited[r][c]) {
					result.add(A.get(r).get(c));
					visited[r][c] = true;
					r--;
					k++;
				} else {
					dir = Direction.FORWARD;
					r++;
					c++;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();

		Integer[] array = { 1, 2, 3 };
		ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(array));
		A.add(a);

		array[0] = 4;
		array[1] = 5;
		array[2] = 6;
		a = new ArrayList<Integer>(Arrays.asList(array));
		A.add(a);

		array[0] = 7;
		array[1] = 8;
		array[2] = 9;
		a = new ArrayList<Integer>(Arrays.asList(array));
		A.add(a);

		SpiralOrderMatrix obj = new SpiralOrderMatrix();
		obj.spiralOrder(A);

		
		 for(int i=0; i<obj.result.size(); i++) { System.out.println(obj.result.get(i)); }
		 
	}

}
