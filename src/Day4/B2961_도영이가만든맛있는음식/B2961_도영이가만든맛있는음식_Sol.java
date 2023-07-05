package Day4.B2961_도영이가만든맛있는음식;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B2961_도영이가만든맛있는음식_Sol {

	static int N;
	static int [] S_arr;
	static int [] B_arr;
	
	static int answer = Integer.MAX_VALUE;
	static int cnt = 0;
	
	public static void subset(int n , int tot_S , int tot_B , boolean flag) {
		if(n==N) {
			if(!flag) return;
			if(answer > Math.abs(tot_S - tot_B)) 
				answer = Math.abs(tot_S - tot_B);
			return;
		}
		subset(n+1 , tot_S * S_arr[n] , tot_B + B_arr[n] , true);
		subset(n+1 , tot_S , tot_B , flag);
	}
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		
		S_arr = new int [N];
		B_arr = new int [N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer token = new StringTokenizer(bf.readLine() , " ");
			S_arr[i] = Integer.parseInt(token.nextToken());
			B_arr[i] = Integer.parseInt(token.nextToken());
		}
		
		subset(0 , 1,0,false);				// 부분집합 재귀
		
		System.out.println(answer);			// 정답 출력
	}
}
