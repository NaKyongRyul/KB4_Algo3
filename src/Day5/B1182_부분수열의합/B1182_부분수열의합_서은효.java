package Day5.B1182_부분수열의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1182_부분수열의합_서은효 {
	static int N;
	static int S;
	static int [] arr;
	static boolean [] isSelected;
	static int [] cal;
	static int answer;
	
	
	static void subset(int n) {
		
		cal = new int[N];
		int sum = 0;
		int check = 0;
		
		if(n == N) {
			for(int i =0; i<N; i++) {
				if(isSelected[i]) {
					check++;
					sum += arr[i];
				}
				
			}
		
		if(sum == S && check != 0) answer++;
		
		return;
		}
		
		isSelected[n] = false;
		subset(n+1);
		
		isSelected[n] = true;
		subset(n+1);
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(bf.readLine(), " ");
		
		N = Integer.parseInt(token.nextToken());
		S = Integer.parseInt(token.nextToken());
		token = new StringTokenizer(bf.readLine(), " ");
		
		 arr = new int[N];
		
		for(int i =0; i<N ;i++)
			arr[i] = Integer.parseInt(token.nextToken());
		
		isSelected = new boolean[N];
		
		subset(0);
		System.out.println(answer);
		
	}

}
