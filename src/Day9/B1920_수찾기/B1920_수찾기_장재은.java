package Day9.B1920_수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1920_수찾기_장재은 {

	static int N;
	static int M;
	static int [] arr;
	static int [] numli;
	
	public static int BinarySearch(int [] arr, int target) {
		int low = 0;
		int high = arr.length - 1;
		int mid = 0;
		while(low <= high) {
			mid = (low + high) / 2;
			if(arr[mid] == target) return 1;
			else if(arr[mid] > target) high = mid -1;
			else low = mid + 1;
		}
		return 0;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int [N];
		
		String [] strs = br.readLine().split(" ");
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(strs[i]);
		
		M = Integer.parseInt(br.readLine());
		numli = new int [M];
		String [] strs2 = br.readLine().split(" ");
		for(int i=0; i<M; i++)
			numli[i] = Integer.parseInt(strs2[i]);
		
		Arrays.sort(arr);
		
		for(int i=0; i<M; i++) {
			int answer = BinarySearch(arr, numli[i]);
			System.out.println(answer);
		}
	}
}