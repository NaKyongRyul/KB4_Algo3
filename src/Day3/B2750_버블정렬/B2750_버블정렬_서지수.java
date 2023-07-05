package Day3.B2750_버블정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2750_버블정렬_서지수 {
	public static void swap(int []arr, int j) {
		int temp=arr[j];
		arr[j]=arr[j+1];
		arr[j+1]=temp;
	}
	
	public static void bubbleSort(int []arr, int n) {
		int temp;
		for(int i=n-1;i>0;i--) {
			for(int j=0;j<i;j++) {
				if(arr[j]<arr[j+1]) {
					swap(arr, j);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int arr[]=new int[N];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(bf.readLine());
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		bubbleSort(arr, N);
		
		for(int i=N-1;i>=0;i--) {
			System.out.println(arr[i]);
		}
		
	}

}
