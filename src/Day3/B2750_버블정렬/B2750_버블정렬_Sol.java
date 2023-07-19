package Day3.B2750_버블정렬;

import java.util.Arrays;
import java.util.Scanner;

public class B2750_버블정렬_Sol {
	
	static void bubbleSort(int [] arr) {
		
		// 내부 구현 //
		int N = arr.length;
		
		for(int i=0; i<N-1; i++) {
			for(int j=0; j<N-i-1; j++) {
				if(arr[j] > arr[j+1]) swap(arr , j , j+1);
			}
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [] arr = new int [N];
		for(int i=0; i<N; i++) arr[i] = sc.nextInt();
		
		// 정렬 구현 //
		bubbleSort(arr);
		
		for(int i=0; i<N; i++) System.out.println(arr[i]);

	}
	
	static void swap(int [] arr , int i , int j ) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}