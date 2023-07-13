package Day4.B2750_병합정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_병합정렬_오원식 {

	public static void sort(int[] arr, int i, int j) {
		if (i >= j)
			return;

		int mid = (i + j) / 2;

		sort(arr, i, mid);
		sort(arr, mid + 1, j);
		merge(arr, i, mid, j);
	}

	public static void merge(int[] arr, int i, int mid, int j) {
		int left = i;
		int right = mid + 1;
		int idx = left;
		int[] temp = new int[arr.length];

		while (left <= mid && right <= j) {

			if (arr[left] <= arr[right]) {
				temp[idx] = arr[left];
				left++;
				idx++;
			} 
			
			else {
				temp[idx] = arr[right];
				right++;
				idx++;
			}
		}

		if (left > mid) {
			for (int k = right; k <= j; k++) {
				temp[idx] = arr[k];
				idx++;
			}
		} 
		
		else {
			for (int k = left; k <= mid; k++) {
				temp[idx] = arr[k];
				idx++;
			}
		}

		for (int k = i; k <= j; k++) {
			arr[k] = temp[k];
			idx++;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(br.readLine());

		sort(arr, 0, N - 1);

		for (int i = 0; i < N; i++)
			System.out.println(arr[i]);
		
		
	}

}
