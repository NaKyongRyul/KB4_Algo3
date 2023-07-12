package Day3.B2750_선택정렬;

import java.util.Scanner;

public class B2750_선택정렬_정지원 {
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int [n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		int minIdx = 0;
		for(int i=0;i<n-1;i++) {
			minIdx = i;
			for(int j=i+1;j<n;j++) {
				if(arr[j]<arr[minIdx]) minIdx = j;
			}
			swap(arr, minIdx, i);
		}
		
				
				
		for(int i=0;i<n;i++) {
			System.out.println(arr[i]);
		}
	}
}
