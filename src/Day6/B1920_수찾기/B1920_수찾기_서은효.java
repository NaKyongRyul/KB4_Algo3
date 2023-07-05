package Day6.B1920_수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1920_수찾기_서은효 {

	static int [] arr;

	static void BinarySearch(int target) {
		// [1, 3, 7, 9, 5] 
		// target = 1
		
		int low = 0; //시작 인덱스
		int high = arr.length-1;// 끝 인덱스 
		
		while( low<=high ) {
			
			int mid = (low+high)/2;
			if(arr[mid] == target ) {
				System.out.println(1);
				return;
			}
			else if (arr[mid] > target) {
				high = mid-1;
			}
			else {
				low = mid +1;
			}
		}
		System.out.println(0);
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		arr = new int [N];
		StringTokenizer token = new StringTokenizer(bf.readLine());
		for(int i =0;i<N;i++) arr[i] = Integer.parseInt(token.nextToken());
		
		int M = Integer.parseInt(bf.readLine());
		token = new StringTokenizer(bf.readLine());
		
		//Arrays.sort(arr);
		for(int i =0;i<M;i++) {
			//BinarySearch(Integer.parseInt(token.nextToken()));
			int target_idx = Arrays.binarySearch(arr, Integer.parseInt(token.nextToken()));
		}
		
		
	}

}
