package quicksort;
import java.util.LinkedList;

public class test {

	public static void main(String[] args) {

		
		QuickSort2 qs2 = new QuickSort2();
		
		int[] test = {1,6,7,2,8,3,0,11,4,17,98,5};
		qs2.quickSort(test, 0, 11);

	}

}
