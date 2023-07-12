package Day3.B2750_버블정렬;

import java.util.Scanner;

public class B2750_버블정렬_김현지 {
	
	public static void swap(int [] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [] arr = new int [N];
		
		for (int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for (int i=0; i<N-1; i++) {
			for (int j=0; j<N-i-1; j++) {
				if (arr[j] > arr[j+1]) {
					swap(arr, j, j+1);
				}
			}
		}
		for (int k: arr) {
			System.out.println(k);
		}
		

	}

}
