package Day3.B2750_선택정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2750_선택정렬_서지수 {
	public static void swap(int []arr,int i, int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	public static void selectionSort(int []arr, int N) {
		int temp, min;
		for(int i=0;i<N-1;i++) {
			min=i;
			
			for(int j=i+1;j<N;j++) {
				if(arr[j]<arr[min]) {
					min=j;
				}
			}

				swap(arr, min, i);

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
		
		selectionSort(arr, N);
		
		for(int i=0;i<N;i++) {
			System.out.println(arr[i]);
		}

	}
}
