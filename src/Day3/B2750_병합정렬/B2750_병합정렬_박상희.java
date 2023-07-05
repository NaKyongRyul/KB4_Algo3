package Day3.B2750_병합정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_병합정렬_박상희 {
	public static void swap(int [] arr, int i, int j) {		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void mergeSort(int [] arr, int lf, int rt) {
		if (lf >= rt) {
			return;
		}
		
		int center = (lf + rt) / 2;
		
		// Divide
		mergeSort(arr, lf, center);
		mergeSort(arr, center + 1, rt);
		
		// Conquer
		int left = lf;
		int right = center + 1;
		int idx = left;
		int [] temp = new int [arr.length];
		
		while (left <= center || right <= rt) {
			if (right > rt || (left <= center && arr[left] < arr[right])) {
				temp[idx++] = arr[left++];
			}
			else {
				temp[idx++] = arr[right++];
			}
		}
		
		for (int i = lf; i <= rt; i++) {
			arr[i] = temp[i];
		}
 	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {			
		// 입력 처리
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		int numArr[] = new int[N];
		for (int n = 0; n < N; n++) {
			numArr[n] = Integer.parseInt(bf.readLine());
		}
		
		// 정렬
		mergeSort(numArr, 0, N - 1);
		
		for (int a : numArr) {
			System.out.println(a);
		}
	}
}
