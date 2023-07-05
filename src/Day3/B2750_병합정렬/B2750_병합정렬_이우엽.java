package Day3.B2750_병합정렬;

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
public class B2750_병합정렬_이우엽 {
	static int[] sorted; // 부분정렬배열
	static int[] arr;
	
	public static void mergeSort(int m, int n) {
		if(m < n) {
			int middle = (m+n)/2; // 무조건 반반으로 나눈다
			mergeSort(m, middle); // 앞의 반의 반의 반의 반.. size가 1이 될때까지
			mergeSort(middle+1, n); // 뒤의 반의 반의 반의 반.. size가 1이 될때까지
			merge(m, middle, n); // size가 1인것부터 병합하며 정렬
		}
	}
	
	public static void merge(int m, int middle, int n) {
		int i = m; // 한쪽 부분집합 시작 인덱스
		int j = middle + 1; // 나머지 부분집합 시작인덱스
		int k = m; // 부분정렬배열 시작인덱스
		
		// 두 부분집합의 각 첫번째 원소부터 비교하여
		// 더 작은 것부터 sorted[k]에 넣기
		while(i <= middle && j <= n) {
			if(arr[i] <= arr[j]) {
				sorted[k] = arr[i];
				i++;
			} else {
				sorted[k] = arr[j];
				j++;
			}
			k++;
		}
		
		// 한쪽 부분집합의 데이터가 다 정렬되었으면
		// 나머지 부분집합의 데이터 순서대로 넣기
		if(i > middle) {
			for(int t = j; t < n; t++) {
				sorted[k] = arr[t];
				k++;
			}
		} else {
			for(int t = i; t < middle+1; t++) {
				sorted[k] = arr[t];
				k++;
			}
		}
		
		// 정렬된 부분 복사
		for(int t = m; t <= n; t++) {
			arr[t] = sorted[t];
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		arr = new int[N];
		sorted = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(sc.nextLine());
		}
		
		mergeSort(0, N-1);
		
		for(int i = 0; i < N; i++) {
			System.out.println(arr[i]);
		}
	}
}
