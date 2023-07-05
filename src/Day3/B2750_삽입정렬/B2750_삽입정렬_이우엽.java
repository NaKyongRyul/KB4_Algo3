package Day3.B2750_삽입정렬;

import java.util.Scanner;

public class B2750_삽입정렬_이우엽 {
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void insertSort(int[] arr) {
		for(int i = 0; i < arr.length-1; i++) {
			int j = i;
			while(j >=0 && arr[j+1] < arr[j]) {
				swap(arr, j, j+1);
				j--;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(sc.nextLine());
		}
		
		insertSort(arr);
		
		for(int i = 0; i < N; i++) {
			System.out.println(arr[i]);
		}
	}

}
