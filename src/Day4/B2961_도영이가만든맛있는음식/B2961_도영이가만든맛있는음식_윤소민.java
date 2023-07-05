package Day4.B2961_도영이가만든맛있는음식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2961_도영이가만든맛있는음식_윤소민 {
	
	static int [] s;
	static int [] b;
	static int N;
	static int cnt;
	static boolean [] isS;
	
	static int sum_s;
	static int sum_b;
	static int min = 1_000_000_000;
	
	static void subset(int num) {
		if(num == N) {
			sum_s=1;
			sum_b=0;
			for(int i=0;i<N;i++) {
				if(isS[i]) {
					sum_s *= s[i];
					sum_b += b[i];
					min = Math.min(Math.abs(sum_s-sum_b), min);
				}
			}			
			return;			
		}
		
		isS[num] = true;
		subset(num+1);
		
		isS[num] = false;
		subset(num+1);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(bf.readLine());
		s=new int[N];
		b=new int[N];
		isS = new boolean[N];

		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			s[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
		}
		subset(0);		
		System.out.println(min);
	}

}