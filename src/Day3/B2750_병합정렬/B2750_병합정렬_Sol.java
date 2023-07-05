package Day3.B2750_병합정렬;

import java.util.Arrays;
import java.util.Scanner;

public class B2750_병합정렬_Sol {

	static void mergeSort(int [] arr , int [] tmp ,  int start , int end) {
		
//		System.out.println(start + "--" + end);
//		for(int i=start; i < end +1 ; i++)System.out.print(arr[i] + " ");
//		System.out.println();
		if(start >= end) {
			return;
		}
		
		int mid = (start + end)/2;
		mergeSort(arr , tmp , start , mid);
		mergeSort(arr , tmp , mid+1 , end);

		int left_p = start;
		int right_p = mid+1;
		int idx = start;
		
		while(left_p <= mid || right_p <= end) {
			
			if(left_p > mid) {
				tmp[idx++] = arr[right_p++];
			}
			
			else if(right_p > end) {
				tmp[idx++] = arr[left_p++];
			}
			
			else if(arr[left_p] > arr[right_p]) {
				tmp[idx++] = arr[right_p++];
			}
			else if(arr[left_p] < arr[right_p]) {
				tmp[idx++] = arr[left_p++];
			}
		}

		for(int i=start; i<end+1; i++) {
			arr[i] = tmp[i];
		}
	}
	
	public static void main(String[] args) {

//		
//		int [] arr = {4,2,7,1,9,6,8,3};
		
		
//        Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//		int [] arr = new int [N];
//		for(int i=0; i<N; i++) arr[i] = sc.nextInt();
		
		int [] arr = {5,2,8,6,4,7,3,1};
		
		int [] temp = new int [arr.length];
		
		
		mergeSort(arr , temp , 0 , arr.length-1);
		
//		for(int i=0; i<N; i++) System.out.println(arr[i]);
		System.out.println(Arrays.toString(arr));
		
	}

}
