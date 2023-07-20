package Day9.B1920_수찾기;

import java.util.Arrays;
import java.util.Scanner;

public class B1920_수찾기_정지원 {
	static int n;
	static int[] arr;
	
	static int biSearch(int target) {
		int low = 0;
		int high = n-1;
		
		
		
		while(low<=high) {
			int mid = (low+high)/2;
			if(arr[mid]== target) {
				return 1;
			}
			else if(arr[mid]> target) {
				high = mid-1;
			}
			else {
				low = mid+1;
			}
		}
		return 0;
	
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		arr = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		int m = sc.nextInt();
		int[] isContains = new int[m];
		
		for(int i=0;i<m;i++) {
			isContains[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		for(int i=0;i<m;i++) {
			
			System.out.println(biSearch(isContains[i]));
		}
		
	}
}
