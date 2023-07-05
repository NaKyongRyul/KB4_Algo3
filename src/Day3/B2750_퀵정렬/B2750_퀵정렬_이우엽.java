package Day3.B2750_퀵정렬;

import java.util.Scanner;

/**
 * 백준2750 수 정렬하기
 * 
 * 입력:
 * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 
 * 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
 * 
 * 출력:
 * 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 *
 */
public class B2750_퀵정렬_이우엽 {
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	public static void quickSort(int[] arr, int startIdx, int endIdx) {
		if(startIdx >= endIdx) {
			return;
		}
		
		int key = startIdx;
		int i = startIdx+1;
		int j = endIdx;
		
		while(i <= j) {
			while(i <= endIdx && arr[i] <= arr[key]) {
				i++;
			}
			while(j > startIdx && arr[j] >= arr[key]) {
				j--;
			}
			
//			엇갈렸을 때
			if(i > j) {
				swap(arr, key, j);
			} else {
				swap(arr, i, j);
			}
		}
		quickSort(arr, startIdx, j-1);
		quickSort(arr, j+1, endIdx);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(sc.nextLine());
		}
		
		quickSort(arr, 0, N-1);
		
		for(int i = 0; i < N; i++) {
			System.out.println(arr[i]);
		}
	}

}
