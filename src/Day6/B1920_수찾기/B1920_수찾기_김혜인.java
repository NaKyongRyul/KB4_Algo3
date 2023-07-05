package Day6.B1920_¼öÃ£±â;

import java.util.Scanner;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1920_¼öÃ£±â_±èÇıÀÎ {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); 
		int [] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		int M = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			if(BinarySearch(arr, sc.nextInt()) >= 0) {
				sb.append(1).append('\n');
			}
			else {
				sb.append(0).append('\n');
			}
		}
		System.out.println(sb);
	}
		
		
	public static  int BinarySearch(int[] arr, int target) {
		int low = 0;
		int high = arr.length-1;
		
		while(low<=high) {
			int mid = (low+high)/2;
			if (arr[mid]==target) return mid;
			else if(arr[mid]>target) high = mid-1;
			else if(arr[mid]<target) low = mid + 1;
		
			else return mid;
		}
		return -1;
}
}
