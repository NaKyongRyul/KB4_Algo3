package Day9.B1920_수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1920_수찾기_강윤서 {
	public static void binarySearch(int[] arr, int target) {
		// 탐색 범위 설정
		int low = 0;
		int high = arr.length-1;
		
		while(low<=high) {
			int mid = (low+high)/2;
			if (target==arr[mid]) { // target값 찾은 경우
				System.out.println("1");
				return;
			}
			if (target<arr[mid]) { // target값이 왼쪽에 있는 경우
				high = mid-1 ;
			} else { // target값이 오른족에 있는 경우
				low = mid+1;
			}
		}
		System.out.println("0");
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		// 숫자 리스트
		int[] numList = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			numList[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numList); // 정렬
		
		int m = Integer.parseInt(br.readLine());
		
		// 확인할 숫자
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<m; i++) {
			binarySearch(numList, Integer.parseInt(st.nextToken()));
		}		
	}
}
