package Day4.B2961_도영이가만든맛있는음식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2961_도영이가만든맛있는음식_김태선 {
	
	static int ans;
	static boolean[] isSelected;
	static int[][] taste;
	static int N;
	
	static void subSet(int cnt, int S, int B) {
		
		if(cnt == N) {
			int falseCnt = 0;
			for(int i = 0; i < N; i++) {
				if(isSelected[i]) continue;
				falseCnt++;
			}
			
			if(falseCnt == N) return;
			ans = Math.min(ans, Math.abs(S - B));
			return;
		}
		
		isSelected[cnt] = true;
		subSet(cnt + 1, S * taste[cnt][0], B + taste[cnt][1]);
		
		isSelected[cnt] = false;
		subSet(cnt + 1, S, B);
		
		
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		isSelected = new boolean[N];
		ans = Integer.MAX_VALUE;
		taste = new int [N][2];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			taste[i][0] = Integer.parseInt(st.nextToken());
			taste[i][1] = Integer.parseInt(st.nextToken());
		}
		
		
		subSet(0,1,0);
		
		System.out.println(ans);
	}
	
}
