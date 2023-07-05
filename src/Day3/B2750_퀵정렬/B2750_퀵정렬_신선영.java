package Day3.B2750_퀵정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2750_퀵정렬_신선영 {

	public static void swap(int [] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static int partition(int[] arr, int start, int end) {
		int pivot = start;
		int left = start + 1;
		int right = end;

		while (left <= right) {
			while (left <= right && arr[left] <= arr[pivot]) left++;
			while (left <= right && arr[right] >= arr[pivot]) right--;
			if (left > right) swap(arr, right, pivot);
			else swap(arr, right, left);
		}

		return right;
	}

	public static void quickSort(int[] arr, int start, int end) {
		if (start >= end) return;

		int pivot = partition(arr, start, end);
		quickSort(arr, start, pivot - 1);
		quickSort(arr, pivot + 1, end);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 입력 처리
		int N = Integer.parseInt(st.nextToken());
		int [] arr = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 정렬
		quickSort(arr, 0, N - 1);
		for (int a : arr) {
			System.out.println(a);
		}

	}

}
