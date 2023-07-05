package Day3.B2750_병합정렬;

import java.util.Scanner;

public class B2750_병합정렬_전상희 {

	public static void mergeSort(int[] arr, int[] temp, int start, int end) {
		if(start>=end) return; // 분할된 배열에 요소가 1개밖에 없을 경우 
		
		int mid = (start + end) / 2;
		mergeSort(arr, temp, start, mid);
		mergeSort(arr, temp, mid+1, end);
		
		int left_p = start;
		int idx = start;
		int right_p = mid + 1;
		
		while(left_p <= mid || right_p <= end) { // 
			// arr[left_p]와 arr[right_p]의 값을 비교해서 작은 값부터 temp에 차례대로 넣는다
			if(left_p > mid) {
				temp[idx++] = arr[right_p++];
			}
			else if(right_p > end) {
				temp[idx++] = arr[left_p++];
			}
			else if(arr[left_p] < arr[right_p]) {
				temp[idx++] = arr[left_p++];
			}
			else if(arr[left_p] > arr[right_p]) {
				temp[idx++] = arr[right_p++];
			}
			
		}		
		// 정렬 끝! 
		for(int i=start; i<end+1; i++) arr[i] = temp[i];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] temp = new int[N];
		
		for(int i=0; i<N; i++) 
			arr[i] = sc.nextInt();
		
		
		mergeSort(arr, temp, 0, N-1);
		
		for(int i : arr) {
			System.out.print(i + " ");
		}
	}

}
