package Day3.B2750_퀵정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_퀵정렬_조성환 {

	private static void quickSort(int[] arr, int start, int end) {
		if (start >= end)
			return;

		int pivot = start;
		int left = start + 1;
		int right = end;


		while (left <= right) {
			while (left <= end && arr[left] <= arr[pivot]) {
				left++;
			}
			while (right > start && arr[right] >= arr[pivot]) {
				right--;
			}
			if (left > right) {
				int temp = arr[right];
				arr[right] = arr[pivot];
				arr[pivot] = temp;
			}
			else {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
		}

		quickSort(arr, start, right - 1);
		quickSort(arr, right + 1, end);

	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		int [] arr = new int [N];
		for (int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		
		quickSort(arr, 0, N-1);
		for (int k : arr) {
			System.out.println(k);
		}
	}
}
