package Day6.B1920_수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1920_수찾기_박찬욱 {
	
	static int N;
	static int M;
	static int [] A; // A[1], A[2], …, A[N]
	static int [] arr; // 자신들의 수가 A안에 존재 확인을 위한 배열
	
	static int binarySearch(int [] arr, int target) {
		int low = 0; // 시작 인덱스
		int high = arr.length - 1; // 끝 인덱스
		while(low <= high) {
			int mid = (low + high) / 2;
			if(arr[mid] == target) {
				return 1;
			}else if(arr[mid] > target) {
				high = mid - 1;
			}else {
				low = mid + 1;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(bf.readLine());
		
		A = new int [N];
		StringTokenizer token = new StringTokenizer(bf.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(token.nextToken());
		}
		
		Arrays.sort(A);
		
		M = Integer.parseInt(bf.readLine());
		
		arr = new int [M];
		token = new StringTokenizer(bf.readLine());
		for(int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(token.nextToken());
		}
		
		for(int i = 0; i < M; i++) {
			System.out.println(binarySearch(A, arr[i]));
		}	
	}
}