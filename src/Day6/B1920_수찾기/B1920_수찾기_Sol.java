package Day6.B1920_수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1920_수찾기_Sol {

	public static int binarySearch(int [] arr , int target) {
		
		int low = 0;
		int high = arr.length-1;
		
		while(low<=high) {
			int mid = (low+high)/2;
			
			if(arr[mid] == target) return 1;
			else if(arr[mid] > target) high = mid -1;
			else low = mid + 1;
		}
		return 0;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(io.readLine());
		int [] arr = new int [N];
		StringTokenizer token = new StringTokenizer(io.readLine());
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(io.readLine());
		token = new StringTokenizer(io.readLine());
		
		int [] m_arr = new int [M];
		for(int i=0; i<M; i++) m_arr[i] = Integer.parseInt(token.nextToken());
		Arrays.sort(arr);
		
		// 이분탐색 직접 구현
		for(int i=0; i<M; i++) System.out.println(binarySearch(arr, m_arr[i]));
	}
	}
