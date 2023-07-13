package Day4.B2750_퀵정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_퀵정렬_전종한 {
	public static void swap(int [] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}


	public static int partition(int [] arr, int left, int right) {
		int pivot = left;
		int lo = left+1;
		int hi = right;
		while(lo <= hi) {
			while(arr[lo] < arr[pivot] && lo < right) lo++;
			while(arr[hi] > arr[pivot] && hi > left) hi--;
			if(lo >= hi) {
				swap(arr, pivot, hi);
				break;
			}else {
				swap(arr, lo, hi);				
			}
		}
		return hi;
	}

	public static void quickSort(int [] arr, int left, int right) {
		if(left >= right) return ;
		int pivot = partition(arr, left, right);
		quickSort(arr, left, pivot-1);
		quickSort(arr, pivot+1, right);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int [] arr = new int [N];

		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		quickSort(arr, 0, N-1);

		for(int a : arr) {
			System.out.println(a);
		}
	}
}
