package Day1.B2018_수들의합;

import java.util.Scanner;

public class B2018_수들의합_서지수 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();

		int count=0;
		
		int arr[]=new int[N+1];
		int ans[]=new int[N+1];
		
		for(int i=1;i<=N;i++) {
			arr[i]=i;
		}
		
		
		for(int start=1;start<=N;start++) {
			int sum=0;
			int end=start;
			while(sum<N) {
				sum+=arr[end];
				end++;
			}
			if(sum==N) {
				count++;	
			}	
			sum=0;	
		}
		
		System.out.println(count);
	}

}
