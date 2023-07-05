package Day6.B1920_수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1920_수찾기_이우엽 {
	static int[] arr;
	public static int binarySearch(int target) {
		int low = 0;
		int high = arr.length - 1;
		while(low <= high) {
			int mid = (low + high)/2;
			if(arr[mid] == target) {
				return 1;
			} else if(arr[mid] < target) {
				low = mid+1;
			} else {
				high = mid-1;
			}
		}
		return 0;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(token.nextToken());
		}
		Arrays.sort(arr);
		int M = Integer.parseInt(br.readLine());
		token = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < M; i++) {
			int cur = Integer.parseInt(token.nextToken());
			int res = binarySearch(cur);
			System.out.println(res);
		}
	}
}
