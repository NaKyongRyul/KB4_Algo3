package Day5.B15650_N과M1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15650_N과M1_장재은 {
	
	static int [] arr;
	static int N;
	static int R;
	static int [] select;
	static boolean[] isSelected;
	
	public static void combination(int idx, int size) {
		if(size == R) {
			for(int i=0; i<R; i++)
				System.out.print(arr[select[i]]+" ");
			System.out.println();
			return;
		}
		for(int i=idx; i<N; i++) {
			if(isSelected[i]) continue;
			
			isSelected[i] = true;
			select[size] = i;
			combination(i,size + 1);
			
			isSelected[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(stk.nextToken());
		R = Integer.parseInt(stk.nextToken());
		
		arr = new int [N];
		for(int i=1; i<=N; i++)
			arr[i-1] = i;
		select = new int [R];
		isSelected = new boolean [N];
					
		combination(0, 0);
	}
}