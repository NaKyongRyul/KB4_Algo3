package Day2.B2493_탑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
//import java.util.Scanner;
import java.util.StringTokenizer;

public class B2493_탑_김태환 {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(bf.readLine());
//		
//		int N = Integer.parseInt(st.nextToken());
//
//		int [] answer= new int[N];
//		int [] arr= new int[N];
//
//		st = new StringTokenizer(bf.readLine());
//		for (int n = 0; n < N; n++) {
//			int num = Integer.parseInt(st.nextToken());
//			arr[n] = num;}
//		
//		for(int i=N-1;i>=0;i--) {
//			for (int j=i-1;j>=0;j--) {
//				if (arr[j]>arr[i]) {
//					answer[i]=j+1;
//					break;
//				}
//				
//			}
//		}
//		for(int i=0;i<N;i++) {
//		System.out.print(answer[i]+" ");
//	}
//
//}
//}

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		Stack <Integer> stack = new Stack <>();
		int N = Integer.parseInt(st.nextToken());
	
		int [] answer= new int[N];
		int [] arr= new int[N];
	
		st = new StringTokenizer(bf.readLine());
		for (int n = 0; n < N; n++) {
			int num = Integer.parseInt(st.nextToken());
			stack.add(num);}
		
		
		for(int i=N-1;i>=0;i--) {
			for (int j=i-1;j>=0;j--) {
				if (arr[j]>arr[i]) {
					answer[i]=j+1;
					break;
				}
				
			}
		}
		for(int i=0;i<N;i++) {
		System.out.print(answer[i]+" ");
		}
	
	}
	}
