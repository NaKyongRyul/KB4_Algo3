package Day6.B1920_수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1920_수찾기_서지수 {
	static int N;
	static int M;
	static int BinarySearch(int []arr, int target) {
		int low=0;
		int high=arr.length-1;
		int mid;
		
		
		while(low<=high) {
			mid=(low+high)/2;
			if (arr[mid]==target) {
				return 1; //검색 성공
			}
			else if(arr[mid]>target) {
				high=mid-1;
			}
			else {
				low=mid+1;
			}
		}
		return 0; //종료조건 검색 실패
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		
		int arrN[]=new int[N];
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++) {
			arrN[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arrN);
		
		st = new StringTokenizer(bf.readLine());
		M = Integer.parseInt(st.nextToken());
		
		int arrM[]=new int[M];
		
		st = new StringTokenizer(bf.readLine());
		
		for(int i=0;i<M;i++) {
			arrM[i]=Integer.parseInt(st.nextToken());
			System.out.println(BinarySearch(arrN, arrM[i]));
		}
		
	}
}


