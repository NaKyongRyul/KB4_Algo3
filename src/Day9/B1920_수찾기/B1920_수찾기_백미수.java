package Day9.B1920_수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1920_수찾기_백미수 {

	static int N;
	static int[] Narr;
	static int M;
	static int[] Marr;
	
	public static void BinarySearch(int num) {
		int start =0;
		int end = N-1;
		int mid;
		
		while(start<=end) {
			mid = (start+end)/2;
			if(Narr[mid]==num) {
				System.out.println("1");
				return;
			}else if(Narr[mid]>num) {
				end = mid-1;
			}else {
				start = mid+1;
			}
		}
		System.out.println("0");
		return;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(io.readLine());
		
		String[] str1 = io.readLine().split(" ");
		Narr = new int[N];
		for(int i=0; i<N; i++) {
			Narr[i] = Integer.parseInt(str1[i]);
		}
		
		M = Integer.parseInt(io.readLine());
		
		String[] str2 = io.readLine().split(" ");
		Marr = new int[M];
		for(int i=0; i<M; i++) {
			Marr[i] = Integer.parseInt(str2[i]);
		}
		
		Arrays.sort(Narr);
		
		for(int i =0; i<M; i++) {
			BinarySearch(Marr[i]);
		}
	}
}
