package Day5.B1068_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1068_트리_조성환 {
	static int N;
	static int[] arr;
	static int D;
	static ArrayList<Integer> tree[];
	static int S;
	static int cnt;;

	static void findleaf(int start) {
		if (start == D) {
			return;
		} else if (tree[start].size() == 0) {
			cnt++;
			return;
		} else {
			for (int i : tree[start]) {
				if (i == D && tree[start].size() == 1) {
					cnt++;
					return;
				}
				findleaf(i);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());

		arr = new int[N];
		tree = new ArrayList[N];
		for (int i = 0; i < tree.length; i++) {
			tree[i] = new ArrayList<>();
		}

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[i] == -1) {
				S = i;
			} else {

				tree[arr[i]].add(i);
			}
		}

		D = Integer.parseInt(bf.readLine());

		findleaf(S);
		System.out.println(cnt);
	}
}