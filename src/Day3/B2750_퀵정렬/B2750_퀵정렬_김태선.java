package Day3.B2750_퀵정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_퀵정렬_김태선 {
	
	public static void swap(int [] arr, int i, int j) {
	
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}
	
	
	public static int partition(int [] arr, int left, int right ) {
		
		int pivot = (left + right) / 2;
		
		while(left < right && arr[pivot] > arr[left]) {
			left++;
		}
		
		while (left < right && arr[pivot] <= arr[right]) {
			right--;
		}
		
		if(left < right && arr[left] > arr[right]) {
			
			swap(arr, left, right);
			if (left == pivot) {
				partition(arr, 0, arr.length - 1);
			} else {
				partition(arr, left, right);
			}
		}
		
		if(left == right) {
			swap(arr, left, pivot);
		}
		
		return left;
	}
	
	
	public static void QuickSorting(int [] arr, int left, int right) {
		
		if (left < right) {
			int p = partition(arr, left, right);
			QuickSorting(arr, left, p - 1);
			QuickSorting(arr, p + 1, right);
			
		}
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int [] arr = new int [N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		
		QuickSorting(arr, 0, N - 1);
		for(int i = 0; i < N; i++) {
			System.out.println(arr[i]);
		}
		

	}

}
