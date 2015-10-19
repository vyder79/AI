package quicksort;

import java.util.Arrays;

public class test {

	public static void main(String[] args) {

		QuickSort qs = new QuickSort();

		int[] test = { 1, 6, 7, 2, 8, 3, 0, 11, 4, 17, 98, -5 };
		int[] testCopy = test.clone();
		int iterations = 10;
		long repeatsInOneIteration = 1000000;

		long i = 0;
		long j = 0;
		long start = 0;
		long end = 0;

		System.out.println("before: " + Arrays.toString(test));

		for (j = 0; j < iterations; j++) {
			start = System.currentTimeMillis();
			for (i = 0; i < repeatsInOneIteration; i++) {
				test = testCopy.clone();
				qs.quickSort(test, 0, 11);
			}
			end = System.currentTimeMillis();
			System.out.println("iteration " + j + ": " + i + " loops, quick sort took: " + (end - start) + " ms");
		}
		
		System.out.println("after: " + Arrays.toString(test));
	}
}
