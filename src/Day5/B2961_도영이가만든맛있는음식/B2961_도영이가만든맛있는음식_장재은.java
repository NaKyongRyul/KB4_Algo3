package Day5.B2961_도영이가만든맛있는음식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2961_도영이가만든맛있는음식_장재은 {
	
	static int N;
	static int totalS;
	static int totalB;
	static int cnt;
	static int min;
	static int [][] arr;
	static boolean[] isSelected;
	
	public static void cook(int n) {
		if(n == N) {
			totalS = 1;
			totalB = 0;
			cnt = 0;
			for(int i=0; i<n; i++) {
				if(isSelected[i]) {
					totalS *= arr[i][0];
					totalB += arr[i][1];
					cnt++;
				}
			}
			if(cnt != 0)
				min = Math.min(min, Math.abs(totalB - totalS));
			return;
		}
		isSelected[n] = true;
		cook(n+1);
		
		isSelected[n] = false;
		cook(n+1);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		isSelected = new boolean [N];
		arr = new int[N][2];
		
		for(int i=0; i<N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(stk.nextToken());
			arr[i][1] = Integer.parseInt(stk.nextToken());
		}		
		min = Integer.MAX_VALUE;
		cook(0);
		System.out.println(min);
	}
}