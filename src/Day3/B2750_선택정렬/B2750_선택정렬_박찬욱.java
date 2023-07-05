package Day3.B2750_선택정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class B2750_선택정렬_박찬욱 {
	
	public static void swap (int [] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void selectSort(int [] arr, int N) {
		for(int i = 0; i < N-1; i++) {
			int min = i; // 최소값의 자리
			for(int j = i; j < N; j++) {
				if(arr[j] < arr[min]) min = j;
			}
			swap(arr, min, i);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력 처리 //
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine()); 
		int [] arr = new int [N];
		for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(bf.readLine());
		
		// 정렬
		selectSort(arr, N);
		
		System.out.println(Arrays.toString(arr));
	}
}
