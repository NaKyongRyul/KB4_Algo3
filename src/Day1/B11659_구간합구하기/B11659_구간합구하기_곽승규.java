package Day1.B11659_구간합구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11659_구간합구하기_곽승규 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // default는 공백임
        
        
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int [] S = new int[N+1]; //구간합 저장할 배열 (0인덱스 안씀) 
		
	
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			S[i] = S[i-1] + Integer.parseInt(st.nextToken()); // S[i] = S[i-1] + A[i]
		}
		
		//System.out.println(Arrays.toString(S));
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int id1 = Integer.parseInt(st.nextToken());
			int id2 = Integer.parseInt(st.nextToken());
			
			System.out.println(S[id2]- S[id1 - 1]); // S[j] - S[i-1]
		}
	}

}
