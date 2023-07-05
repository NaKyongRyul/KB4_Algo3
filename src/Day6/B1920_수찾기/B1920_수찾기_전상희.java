package day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1920_수찾기 {
	static int BinarySearch(int[] arr, int target) { // arrA 4 1 5 2 3
		int low = 0;
		int high = arr.length-1;
		//System.out.println(low + " " + high);
		int mid;
		while(low<=high) {
			mid = (low + high) / 2;
			//System.out.println(mid + " : " + arr[mid]);
			if(arr[mid] == target) return 1;
			else if(arr[mid] > target) high = mid - 1;
			else low = mid + 1;
		}
		return 0;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(token.nextToken());
		int[] arrA = new int[N];
		token = new StringTokenizer(bf.readLine());
		for(int i=0; i<N; i++) arrA[i] = Integer.parseInt(token.nextToken());
		
		int M = Integer.parseInt(bf.readLine());
		token = new StringTokenizer(bf.readLine());
		int[] arrM = new int[M];
		for(int i=0; i<M; i++) arrM[i] = Integer.parseInt(token.nextToken());
		
		Arrays.sort(arrA); // 정렬을 기반으로 돌아가는 알고리즘이기 때문에 정렬을 꼭 해줘야 된다!@
		
		for(int m : arrM) { // 1 3 7 9 5
			System.out.println(BinarySearch(arrA, m));
		}
	}
}
