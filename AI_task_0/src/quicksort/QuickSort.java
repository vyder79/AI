package quicksort;

import java.util.Random;

public class QuickSort {
	
	int partition(int arr[], int left, int right)
	{
	      int i = left, j = right;
	      int tmp;

	      //int element = left;
	      //int element = (left + 1 > right-1 ? right-1 : left+1);
	      //int element = (left+2 > right-1 ? (left+1 > right-1 ? right-1 : left+1) : left+2);
	      
	      int element = (left + right) / 2;
	      
	      //int element = (right-2 < left ? (right-1 < left ? left : right-1) : right-2);
	      //int element = right-1;
	      //int element = right;
	      
	      //int element = new Random().nextInt(right-left) + left;
	      
	      int pivot = arr[element];
	      
	      //System.out.println("left: " + left + " right: " + right + " element: " + element + " pivot(array value): " + pivot);
	      
	      while (i <= j) {
	            while (arr[i] < pivot)
	                  i++;
	            while (arr[j] > pivot)
	                  j--;
	            if (i <= j) {
	                  tmp = arr[i];
	                  arr[i] = arr[j];
	                  arr[j] = tmp;
	                  i++;
	                  j--;
	            }
	      };
	     
	      return i;
	}
	 
	void quickSort(int arr[], int left, int right) {
	      int index = partition(arr, left, right);
	      if (left < index - 1)
	            quickSort(arr, left, index - 1);
	      if (right > index)
	            quickSort(arr, index, right);
	}
}
