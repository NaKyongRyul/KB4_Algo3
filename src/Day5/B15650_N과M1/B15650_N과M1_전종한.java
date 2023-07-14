package Day5.B15650_N과M1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15650_N과M1_전종한 {
	static int [] arr;
	static int [] select;
	static boolean [] isSelected;

	static int N;
	static int M;
	static StringBuilder sb;

	public static void combination(int idx, int size) {
		if(size == M) {
			sb.append(arr[select[0]]);
			for(int i=1; i<M; i++) {
				sb.append(" " + arr[select[i]]);
			}
			sb.append("\n");
			return;
		}

		for(int i=idx; i<N; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			select[size] = i;
			combination(i, size+1);
			isSelected[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String [] strs = bf.readLine().split(" ");

		N = Integer.parseInt(strs[0]); M = Integer.parseInt(strs[1]);
		arr = new int [N];
		isSelected = new boolean[N];
		select = new int [M];
		sb = new StringBuilder();

		for(int i=1; i<N+1; i++) {
			arr[i-1] = i;
		}

		combination(0,0);
		System.out.println(sb);
	}
}
