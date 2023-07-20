package Day9.B1920_수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1920_수찾기_나웅기 {
	static int n;
	static int m;
	static int [] arr;
	static StringBuilder sb;
	
	public static void binary(int x) {
		int low = 0;
		int high = n-1;
		int mid;
		while (low <= high) {
			mid = (low+high)/2;
			if (arr[mid] == x) {
				sb.append(1 + "\n");
				return;
			} else if (arr[mid] > x) {
				high = mid -1;
			} else {
				low = mid + 1;
			}
		}
		sb.append(0 + "\n");
		return;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(reader.readLine());
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		arr = new int [n];
		
		for (int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		m = Integer.parseInt(reader.readLine());
		st = new StringTokenizer(reader.readLine());
		sb = new StringBuilder();
		for (int i = 0; i<m; i++) {
//			if (Arrays.binarySearch(arr, Integer.parseInt(st.nextToken())) > -1) {
//				System.out.println(1);
//			} else {
//				System.out.println(0);
//			}
			binary(Integer.parseInt(st.nextToken()));
		}
		System.out.println(sb);
		
	}
}
