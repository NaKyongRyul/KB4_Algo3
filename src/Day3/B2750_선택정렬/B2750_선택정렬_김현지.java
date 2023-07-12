package Day3.B2750_선택정렬;

import java.util.Scanner;

public class B2750_선택정렬_김현지 {

	public static void swap(int [] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [] arr = new int [N];
		
		// 배열 값 입력받기
		for (int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int minIdx;
		for (int i=0; i<N-1; i++) {
			// 최소값의 위치 초기값
			minIdx = i;
			for (int j=i+1; j<N; j++) {
				if (arr[j] < arr[minIdx]) {
					minIdx = j;
				}
			}
			swap(arr, minIdx, i);
			
		}
		for (int k: arr) {
			System.out.println(k);
		}
		

	}

}
