package Day4.B2750_퀵정렬;

import java.util.Scanner;

public class B2750_퀵정렬_김현지 {
	
	public static void swap(int [] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	
	public static int partition(int [] arr, int start, int end) {
		int pivotIdx = start;
		int left = start + 1;
		int right = end;
		
		while (left <= right) {
			// left 전진
			while (true) {
				// pivot보다 큰 값이 나올때까지 left 1씩 증가
				if (arr[left] > arr[pivotIdx]) break;
				left++;
			}
			// right 전진
			while (true) {
				// pivot보다 작은 값이 나올때까지 right 1씩 감소
				if (arr[left] < arr[pivotIdx]) break;
				right--;
			}
			
			// left와 right가 엇갈리지 않을 때
			if (left <= right) {
				swap(arr, left, right);
			// left와 right가 엇갈릴 때
			} else {
				swap(arr, right, pivotIdx);
			}
		}
		// pivot의 위치를 엇갈린 지점으로 지정
		return right;
	}
	
	public static void quickSort(int [] arr, int start, int end) {
		// 종료 조건
		if (start >= end) return;
		
		int pivot = partition(arr, start, end);
		
		// 확장 조건
		quickSort(arr, start, pivot-1);
		quickSort(arr, pivot+1, end);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [] arr = new int [N];
		
		// 배열 값 입력받기
		for (int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		quickSort(arr, 0, N-1);
		
		for (int k:arr) {
			System.out.println(k);
		}

	}

}
