package Day3.B2750_병합정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_병합정렬_조성환 {

	public static void mergeSort(int[] arr, int end) {

		int mid = end / 2;
		

		int[] left_arr = new int[mid];
		int[] right_arr = new int[end - mid];
		
		for (int i = 0; i < mid; i++) {
			left_arr[i] = arr[i];
		}
		for (int i = mid; i < end; i++) {
			right_arr[i - mid] = arr[i];
		}

		if (end < 2) {
			return;
		}

		mergeSort(left_arr, mid);
		mergeSort(right_arr, end - mid);
		merge(arr, left_arr, right_arr, mid, end - mid);

	}

	public static void merge(int[] arr, int[] left, int[] right, int mid, int end) {
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < mid && j < end) {
			if (left[i] <= right[j]) {
				arr[k++] = left[i++];
			} else {
				arr[k++] = right[j++];
			}
		}
		while (i < mid) {
			arr[k++] = left[i++];
		}
		while (j < end) {
			arr[k++] = right[j++];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}

		mergeSort(arr, N);
		for (int k : arr) {
			System.out.println(k);
		}
	}
}
