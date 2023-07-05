package Day1.B11659_구간합구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11659_구간합구하기_윤소민 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine()," ");
		
			
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(bf.readLine());
		int [] arr = new int[N+1];
		for(int i=1;i<N+1;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int S[]=new int [N+1];
		for(int i=1;i<N+1;i++) {
			S[i]= S[i-1]+arr[i];
		}
		
		for(int k=0;k<M;k++) {
			st = new StringTokenizer(bf.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken()); 

			System.out.println(S[j]-S[i-1]);
	
		}
	}
	
}

