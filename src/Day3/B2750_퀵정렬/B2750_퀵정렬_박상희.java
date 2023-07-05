package Day3.B2750_퀵정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_퀵정렬_박상희 {
	public static void swap(int [] arr, int i, int j) {		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static int partition(int [] arr, int lf, int rt) {
		int pivot = lf;
		int left = lf;
		int right = rt;
		
		while (left < right) {
			while (left < right && arr[left] < arr[pivot]) {
				left++;
			}
			while(left < right && arr[right] > arr[pivot]) {
				right--;
			}
			
			swap(arr, left, right);
		}
		
		arr[lf] = arr[left];
		arr[left] = arr[pivot];
		
		return left;
	}
	
	public static void quickSort(int [] arr, int lf, int rt) {
		if (lf >= rt) {
			return;
		}
		
		int pivot = partition(arr, lf, rt);
		
		quickSort(arr, lf, pivot - 1);
		quickSort(arr, pivot + 1, rt);
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
		quickSort(numArr, 0, N - 1);
		
		for (int a : numArr) {
			System.out.println(a);
		}
	}
}
