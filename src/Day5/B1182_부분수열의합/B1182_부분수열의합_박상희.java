package Day5.B1182_부분수열의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1182_부분수열의합_박상희 {
	static int N;
	static int S;
	static int [] sequence;
	static boolean [] isSelected;
	static int count;
	
	static void subSet(int num) {
		int sum = 0;
		boolean flag = false;
		
		if (num == N) {
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					flag = true;
					sum += sequence[i];
				}
			}
			
			if (sum == S && flag) {
				count++;
			}
			
			return;
		}
		
		isSelected[num] = false;
		subSet(num + 1);

		isSelected[num] = true;
		subSet(num + 1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(bf.readLine(), " ");
		
		N = Integer.parseInt(token.nextToken());
		S = Integer.parseInt(token.nextToken());
		
		token = new StringTokenizer(bf.readLine(), " ");
		
		sequence = new int[N];
		for (int n = 0; n < N; n++) {
			sequence[n] = Integer.parseInt(token.nextToken());
		}
		isSelected = new boolean [N];
		
		subSet(0);
		System.out.println(count);
	}
}
