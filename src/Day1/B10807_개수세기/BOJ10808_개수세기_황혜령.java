package Day1.B10807_개수세기;


import java.util.Scanner;

public class BOJ10808_개수세기_황혜령 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		int v = sc.nextInt();
		
		int cnt = 0;
		for(int i : arr)
			if(i == v) cnt++;
		
		System.out.println(cnt);		
	}
}