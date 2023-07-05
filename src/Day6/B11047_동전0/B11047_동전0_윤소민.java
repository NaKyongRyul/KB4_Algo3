package Day6.B11047_동전0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11047_동전0_윤소민 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int [] A = new int [N];
		for(int i=0;i<N;i++) {
			A[i] = Integer.parseInt(bf.readLine());
		}
		int cnt=0;
		for(int i =N-1;i>=0;i--) {
			if(K - A[i]>=0) {
				while(K-A[i]>=0) {
					K -= A[i];    //cnt += K /A[i]; 
					cnt++;        //K = K%A[i]; 
					//System.out.println("k : "+K+" A[i] : "+A[i]+" cnt: "+cnt);
				}
				
			}
		}
		System.out.println(cnt);
		
	}

}