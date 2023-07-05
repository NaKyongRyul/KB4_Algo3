package Day3.B2750_퀵정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_퀵정렬_곽승규 {
	
	public static void swap(int [] arr, int i, int j) {

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}
	
	public static void quickSort(int [] arr) {
		sort(arr, 0, arr.length-1);
	}
	
	public static void sort(int [] arr, int start, int end) {
		
		// 종료조건
		if (start >= end) return;
		
		int pivot = start;
		
		int left = start + 1;
		int right = end;
		
		while (left <= right) {
			while(left <= end && arr[left] <= arr[pivot]) {
				left++;
			}
			while( right > start && arr[right] >= arr[pivot] ) {
				right--;
			}
			
			
			// 엇갈렸을 때 
			if(left > right) {
				swap(arr, right, pivot);
			}
			else {
				swap(arr, left, right);
			}
		}
		
		sort(arr, start, right-1);
		sort(arr, right+1, end);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 입력 처리 //
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());

		int [] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		
		
		//퀵 정렬 수행
		quickSort(arr);
		
		for(int value : arr) {
			System.out.println(value);
		}
		
	}

}
