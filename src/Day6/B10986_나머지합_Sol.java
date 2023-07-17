package Day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B10986_나머지합_Sol {

	public static void main(String[] args) throws IOException {


//		int a = Integer.MAX_VALUE;
//		System.out.println(a);
//		System.out.println(++a);
//		long b = Long.MAX_VALUE;
//		System.out.println(b);
		

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(bf.readLine() , " ");
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		token = new StringTokenizer(bf.readLine() , " ");

		// 누적합 배열 S
		long [] arr = new long [N];
		long [] S = new long [N];

		for(int i=0; i<N; i++) {
			arr[i] = Long.parseLong(token.nextToken());

			if(i==0) S[i] = arr[i];
			else S[i] = S[i-1] + arr[i];
		}
		
		//System.out.println("구간합 배열 : " + Arrays.toString(S));
		
		// SM 배열
		for(int i=0; i<S.length; i++) {
			S[i] = S[i]%M;
		}

		//System.out.println("구간합%M 배열 : " + Arrays.toString(S));
		
		long [] count = new long [M];
		
		for(int i=0; i<N; i++) {
			count[(int) S[i]] = count[ (int) S[i]] + 1;
		}
		
		//System.out.println("count 배열 : " + Arrays.toString(count));
		
		long ans = 0;
		
		// 1. SM[i] == 0 인 경우
		ans += count[0];
		
		// 2. SM[i] == SM[j] 경우
		for(int i=0; i<M; i++) {
			ans += count[i]*(count[i] - 1)/2;
		}
		
		System.out.println(ans);
		
		
	}
}
