package Day3.B10986_나머지합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B10986_나머지합_Sol {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(bf.readLine() , " ");
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		long [] arr = new long [N];
		long [] S = new long [N];
		token = new StringTokenizer(bf.readLine() , " ");
		for(int i=0; i<N; i++) {
			arr[i] = Long.parseLong(token.nextToken()); 
			
			if(i==0) S[i] = arr[i];
			else
				S[i] = S[i-1] + arr[i];
		}
		
		// 누적합%나머지 연산
		for(int i=0; i<N; i++) S[i] = S[i]%M;
		long ans = 0;
		long [] count = new long [M];
		
		for(int i=0; i<N; i++) {
			count[ (int) S[i]]++;
		}
		
		for(int i=0; i<M; i++) {
			ans += (count[i]*(count[i]-1))/2;
		}
		
		ans += count[0];
		System.out.println(ans);
	}
}
