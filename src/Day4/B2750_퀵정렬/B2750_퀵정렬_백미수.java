package Day4.B2750_퀵정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_퀵정렬_백미수 {
	static int[] arr;
	
	public static void swap(int[] arr, int i, int j) {
		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void quickSort(int[] arr, int left, int right) {

		//재귀 - 1. 종료조건 2. 확장 => ex)이등분, 삼등분 ,,,
		
		if(left>=right) return;
		
		int pivot = partition(arr, left, right);
		quickSort(arr, left, pivot-1);
		quickSort(arr, pivot+1, right);

	}
	
	public static int partition(int[] arr,int left, int right) {
		
		int pivot = arr[left];	//pivot값
		int first = left;
		left = left+1;
		
		while(left<=right){
			if(pivot>=arr[left])
				left++;
			
			if(pivot<=arr[right])
				right--;
			
			if((left<right)&&(arr[left]>arr[right])&& (pivot<arr[left])&&(pivot>arr[right]))
				swap(arr, left, right);
			
		}
		
		int pivotIdx = right;
		swap(arr, first, pivotIdx);//pivot, right swap
		
		return pivotIdx;
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(reader.readLine());
		int[] arr = new int[N];
		for(int i =0; i<N; i++) {
			int num = Integer.parseInt(reader.readLine());
			arr[i] = num;
		}

		int left = 0;
		int right = N-1;
		
		quickSort(arr, left, right);
		
		for(int i =0; i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
}
