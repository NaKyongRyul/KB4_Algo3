package Day1.B11659_구간합구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B11659_구간합구하기_김태환 {

	public static void main(String[] args) {
//
//		Scanner sc = new Scanner(System.in);
//		int N= sc.nextInt();
//		int M= sc.nextInt();
//		
//		int [] arr= new int[N];
//		int [] answer = new int[M];
//		for(int i=0;i<N;i++) {
//			arr[i]=sc.nextInt();
//			
//		}
//		for (int i=0;i<M;i++) {
//			int a=sc.nextInt();
//			int b=sc.nextInt();
//			
//			for(int j=a;j<=b;j++) {
//				answer[i]+=arr[j-1];
//			}
//			System.out.println();
//
//
//			System.out.println(answer[i]);
//	}
//		sc.close();
//		
//	}
//		
//}
		Scanner sc = new Scanner(System.in);
	    int N = sc.nextInt();
	    int M = sc.nextInt();
	    
	    int[] arr = new int[N+1];
	    int[] prefixSum = new int[N+1];
	    for (int i=1; i<=N; i++) {
	        arr[i] = sc.nextInt();
	        prefixSum[i] = prefixSum[i-1] + arr[i];
	    }
	    
	    for (int i=0; i<M; i++) {
	        int a = sc.nextInt();
	        int b = sc.nextInt();
	        System.out.println(prefixSum[b] - prefixSum[a-1]);
	    }
	    
	    sc.close();
	}
}


