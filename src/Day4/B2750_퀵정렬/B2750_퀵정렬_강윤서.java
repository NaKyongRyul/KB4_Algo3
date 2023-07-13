package Day4.B2750_퀵정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_퀵정렬_강윤서 {
	public static void swap(int [] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void quickSort(int [] arr, int start, int end) {
		if (start>=end) return;
		
		int pivot = start;
		int left = start+1;
		int right = end;
		
		while(left<=right) {
			while(left<=end && arr[left]<=arr[pivot]) { // pivot보다 큰 값 만날때까지 오른쪽으로 이동
				left++;
			}
			while(right>start && arr[right]>=arr[pivot]) { // pivot보다 작은 값 만날때까지 왼쪽으로 이동
				right--;
			}
			if (left>right) { // left와 right가 엇갈린 경우
				swap(arr, right, pivot); // pivot 위치의 값 변경
			} else {
				swap(arr, left, right); // left, right 위치의 값 변경
			}
		}
		
		quickSort(arr, start, right-1);
		quickSort(arr, right+1, end);		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		// 수 입력
		int [] numList = new int[n];
		for (int i=0; i<n; i++) {
			numList[i] = Integer.parseInt(br.readLine());
		}
		
		// 퀵 정렬
		quickSort(numList, 0, n-1);
		
		// 결과 출력
		for (int i=0; i<n; i++) {
			System.out.println(numList[i]);
		}
	}
}
