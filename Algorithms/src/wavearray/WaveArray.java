package wavearray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class WaveArray {
	
	public ArrayList<Integer> wave(ArrayList<Integer> A) {
		Collections.sort(A);

		for (int i = 0; i < A.size() - 1; i += 2) {
			int temp = A.get(i);
			A.set(i, A.get(i + 1));
			A.set(i + 1, temp);
		}
		return A;
	}

	public static void main(String[] args) {
		Integer[] array = { 1, 2, 3, 4, 5, 6};
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(array));

		WaveArray obj = new WaveArray();
		obj.wave(A).forEach(e-> System.out.print(e+" "));

	}

}
