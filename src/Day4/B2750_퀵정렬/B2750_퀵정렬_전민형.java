package Day4.B2750_퀵정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2750_퀵정렬_전민형 {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(reader.readLine());
		
		int [] arr = new int [num];
		
		for(int i = 0; i<num; i++) {
			arr[i] = Integer.parseInt(reader.readLine());
		}
		
		quickSort(arr, 0, num-1);
		
		for(int i = 0; i<num; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void swap (int arr[], int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static int partition(int arr[], int left, int right) {
		
		int i=left+1;
		int j=right;
		
		while(i<=j) {
			
			while(i<=j && (arr[left]>arr[i])) {
				i++;
				

			}
			while(i<=j && arr[left]<arr[j]) {
				j--;
				
				
			}
			if(i<=j) {
				swap(arr, i, j);
			}

		}

		swap(arr, left, j);

		return j;
				
	}
	
	public static void quickSort(int arr[], int left, int right) {
		if(left>=right) return;
		int pivot = partition(arr, left, right);
		quickSort(arr, left, pivot-1);
		quickSort(arr, pivot+1, right);
		
		
	}

}
