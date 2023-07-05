package Day4.B1759_암호만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class B1759_암호만들기_조성환 {

	static char[] arr;
	static int L;
	static int C;
	static int cnt_a, cnt_b;
	static int[] selection;
	static boolean[] isVisited;
	static char[] arr_lst;
	

	static void combination(int r, int start) {
		if (r == L) {
			int cnt_a = 0;
			int cnt_b = 0;
			for (int i = 0; i < L; i++) {
				if (arr[selection[i]] == 'a' || arr[selection[i]] == 'e' || arr[selection[i]] == 'i'
						|| arr[selection[i]] == 'o' || arr[selection[i]] == 'u') {
					cnt_a++;
				}else {
					cnt_b++;
				}
			}
			if (cnt_a >= 1 && cnt_b >=2) {
				arr_lst = new char[L];
				for (int j = 0; j < L; j++) {
					System.out.print(arr_lst[j]);
				}
			}else {
				return;
			}

			System.out.println();
			return;
		}

		for (

				int i = start; i < arr.length; i++) {
			if (isVisited[i])
				continue;
			isVisited[i] = true;
			selection[r] = i;
			combination(r + 1, i);
			isVisited[i] = false;

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new char[C];
		String str = bf.readLine();
		for (int i = 0; i < C; i++) {
			arr[i] = str.charAt((i * 2));
		}
		
		selection = new int[L];
		isVisited = new boolean[arr.length];
		
		Arrays.sort(arr);
		combination(0, 0);
	}

}
