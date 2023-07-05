package Day6.B1920_수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1920_수찾기_조성환 {
	
	static void BinarySearch(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;
		while(left <= right) {
			int mid = (left + right) / 2;
			if (arr[mid] == target) {
				System.out.println(1);
				return;
			}else if(arr[mid] > target) {
				right = mid - 1;
			}else {
				left = mid + 1;
			}
		}
		System.out.println(0);
		return ;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int [] arr = new int [N];
		
		st = new StringTokenizer(bf.readLine()," ");
		for (int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int M = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine()," ");
		for (int i = 0 ; i < M ; i++) {
			int target = Integer.parseInt(st.nextToken());
			BinarySearch(arr, target);
		}
	}
}
