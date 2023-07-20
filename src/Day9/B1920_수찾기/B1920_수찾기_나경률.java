package Day9.B1920_수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1920_수찾기_나경률 {
	static int N, M;
	static int[] inputArr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		inputArr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			inputArr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(inputArr);
//		System.out.println(Arrays.toString(inputArr));
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<M; i++) {
			int findNum = Integer.parseInt(st.nextToken());
			binarysearch(inputArr[0], inputArr[N-1], findNum);
		}
		System.out.println(sb);
	}
	
	static void binarysearch(int low, int high, int target) {
		while(low <= high) {
			int mid = (low + high)/2;
			if(target > mid) {
				low = mid + 1;
			} else if(target < mid) {
				high = mid - 1;
			} else {
				sb.append(1 + "\n");
				return;
			}
		}
		sb.append(0 + "\n");
	}

}
