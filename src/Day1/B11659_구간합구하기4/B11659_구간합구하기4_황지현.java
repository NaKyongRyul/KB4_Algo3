package Day1.B11659_구간합구하기4;

import java.util.Scanner;

public class B11659_구간합구하기4_황지현 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int [] arr = new int[n+1];
		for(int i=1;i<=n;i++) {
			arr[i]=arr[i-1]+sc.nextInt();
	
		}
		
		for(int j=0;j<m;j++) {
			int start=sc.nextInt();
			int end=sc.nextInt();
			System.out.println(arr[end]-arr[start-1]);
			
		}
	}
}
