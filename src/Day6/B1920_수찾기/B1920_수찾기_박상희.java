package Day6.B1920_수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1920_수찾기_박상희 {
	static int BinarySearch(int arr[], int target) {
		int low = 0; // 시작 인덱스
		int high = arr.length - 1; // 끝 인덱스

		while (low <= high) {
			int mid = (low + high) / 2;
			
			if (arr[mid] == target) {
				return 1;
			}
			else if (arr[mid] > target) {
				high = mid - 1;
			}
			else {
				low = mid + 1;
			}
		}
		
		return 0;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		StringTokenizer token = new StringTokenizer(bf.readLine(), " ");
		
		int arr[] = new int[N];
		for (int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(token.nextToken());
		}
		Arrays.sort(arr); // 배열 정렬
		
		int M = Integer.parseInt(bf.readLine());
		
		token = new StringTokenizer(bf.readLine(), " ");
		
		int searchArr[] = new int[M];
		for (int m = 0; m < M; m++) {
			searchArr[m] = Integer.parseInt(token.nextToken());
			System.out.println(BinarySearch(arr, searchArr[m]));
		}
	}
}
