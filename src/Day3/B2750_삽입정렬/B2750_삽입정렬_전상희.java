package Day3.B2750_삽입정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2750_삽입정렬_전상희 {
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void insertionSort(int[] arr) {
		for(int i=1; i<arr.length; i++) {
			int now = arr[i];
			for(int j=i-1; j>=0; j--) {
				if(arr[j]>now) swap(arr, j, j+1);
				else break;
			}
		} 
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		/* 입력 처리 */
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		
		// 정렬
		insertionSort(arr);
		
		for(int i : arr) {
			System.out.println(i);
		}
	}

}
