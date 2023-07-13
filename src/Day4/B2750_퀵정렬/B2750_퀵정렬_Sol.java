package Day4.B2750_퀵정렬;

import java.util.Arrays;

public class B2750_퀵정렬_Sol {
	
	public static void swap(int [] arr , int a , int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static void quickSort(int [] arr , int start , int end) {

		// 1. 종료 조건 = 잘못되면 => 무한 루프
		if(start >= end) return;
		
		int pivot = partition(arr , start ,  end);
		
		// 2. 확장
		quickSort(arr , start , pivot - 1);
		quickSort(arr , pivot + 1 , end);
		
	}
	
	public static int partition(int [] arr , int start , int end) {
		
		int pivot_idx = start;
		int left = start + 1;
		int right = end;
		
		while(left <= right) {
			
			// left 전진 = pivot 큰 값을 찾기 위함
			while(left <= right && arr[left] <= arr[pivot_idx]) {
				left++;
			}
			
			// right 전진 = pivot 작은 값을 찾기 위함
			while(left <= right && arr[right] >= arr[pivot_idx]) {
				right--;
			}
			
			// 엇갈리지 않은 경우 = left , right 전부 다 찾은 경우 => swap
			if(left <= right) swap(arr , left , right);
			// 엇갈린 경우 = 탐색 종료 = pivot <-> right 바꿔주기
			else {
				swap(arr , right ,pivot_idx);
			}
		}
		return right;
	}
	
	
	public static void main(String[] args) {
		
		int [] arr = {5,7,1,4,9};
//		int pivot_idx = partition(arr , 0 , arr.length-1);
//		System.out.println(pivot_idx);
		
		quickSort(arr, 0, arr.length-1);
		
		System.out.println(Arrays.toString(arr));
		
		
		
		
	}
	
}
