package Day5.B1182_부분수열의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1182_부분수열의합_곽승규 {
	static int N;
	static int S;
	static int [] ary;
	static int [] select;
	static boolean [] isVisited;
	static int count;
	static int sum;
	
	
	static void subset(int num) {
		
		// 종료 조건
		if (num == N) {
			sum = 0;
			boolean flag = false; // 공집합 제거하기 위해
			for(int i = 0; i < N; i++) {
				if(isVisited[i]) {
					flag = true;
					sum += ary[i];
				}
			}
			if (sum == S && flag) {
				count++;
			} 
			
			return;
		}
		
		// 선택 o
		isVisited[num] = true;
		subset(num + 1);
		
		// 선택 x
		isVisited[num] = false;
		subset(num + 1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		ary = new int[N];
		select = new int[N];
		isVisited = new boolean[N];
		
		st = new StringTokenizer(bf.readLine());
		
		for (int i = 0; i < N; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
		}
		
		count = 0;
		//System.out.println(Arrays.toString(ary));
		subset(0);
		System.out.println(count);

	}

}
