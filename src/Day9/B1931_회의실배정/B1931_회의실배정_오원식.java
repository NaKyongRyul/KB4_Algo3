package Day9.B1931_회의실배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1931_회의실배정_오원식 {

	static int N;
	static int[][] meeting;
	static int standard;
	static int res = 1;

	public static int count() {
		standard = meeting[0][1];

		for (int i = 1; i < N; i++) {
			if (meeting[i][0] >= standard) {
				res += 1;
				standard = meeting[i][1];
			}
		}

		return res;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		meeting = new int[N][2];

		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			meeting[i][0] = Integer.parseInt(s[0]);
			meeting[i][1] = Integer.parseInt(s[1]);
		}

//		Arrays.sort(meeting, new Comparator<int[]>() {
//			
//			@Override
//			public int compare(int[] a, int[] b) {
//				return a[1] != b[1] ? a[1] - b[1] : a[0] - b[0];
//			}
//		});
		
		Arrays.sort(meeting, (a,b) -> ((a[1] != b[1]) ? a[1] - b[1] : a[0] - b[0]));
		
		System.out.println(count());

	}
}
