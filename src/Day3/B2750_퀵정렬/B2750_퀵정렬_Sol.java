package Day3.B2750_퀵정렬;

import java.util.Arrays;
import java.util.Scanner;

public class B2750_퀵정렬_Sol {

	public static void swap(int [] arr , int a , int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static int partition(int [] arr , int start , int end) {
		int pivot = start;
		int left = start + 1;
		int right = end;
		while(left<=right) {
			while(left<=right && arr[left] <= arr[pivot] ) left++;
			while(left<=right && arr[right] >= arr[pivot]) right--;
			// 엇갈린 경우
			if(left>right) 
				swap(arr, right , pivot);
			else
				swap(arr, left, right);
		}
		return right;
	}
	
	public static void quickSort(int [] arr , int start , int end) {
		if(start>=end) return;   // 종료조건
		int pivot = partition(arr , start , end);
		quickSort(arr , start , pivot-1);
		quickSort(arr , pivot+1 , end);
	}
	
	public static void main(String[] args) {

		int [] arr = {5,2,7,1,9,6,8};
		System.out.println(Arrays.toString(arr));
		quickSort(arr, 0 , arr.length-1);
		System.out.println(Arrays.toString(arr));
		
	}
}
