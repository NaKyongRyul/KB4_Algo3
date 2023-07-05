package Day3.B2750_퀵정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_퀵정렬_전상희 {
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	// left, right, partition
	public static int partition(int[] arr, int left, int right) {
		int pivot = arr[left];
		
		int i = left;
		int j = right;
		
		while(i<j) {
			while(pivot < arr[j]) j--;
			while(i<j && pivot >= arr[i]) i++;
			swap(arr, i, j);
		} 
		
		arr[left] = arr[i];
		arr[i] = pivot;
		// 새로운 pivot 지정 
		return i;
	}
	
	public static void quickSort(int[] arr, int left, int right) {
		if(left >= right)
			return;
		int pivot = partition(arr, left, right); 
		quickSort(arr, left, pivot-1);
		quickSort(arr, pivot+1, right);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		
		quickSort(arr, 0, arr.length-1);
		
		for(int i : arr) {
			System.out.println(i);
		}
		
	}
}
