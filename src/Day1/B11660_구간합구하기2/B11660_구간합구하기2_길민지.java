package Day1.B11660_구간합구하기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11660_구간합구하기2_길민지 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int arr[][] = new int[N+1][N+1];
		
		// 배열 입력
		for (int i=1; i<N+1; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j=1; j<N+1; j++) {
				arr[i][j] = arr[i-1][j] + arr[i][j-1] + Integer.parseInt(st.nextToken()) - arr[i-1][j-1];
			}
		}
		
		// 네 개의 정수 입력
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(bf.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			System.out.println(arr[x2][y2]-arr[x2][y1-1]-arr[x1-1][y2]+arr[x1-1][y1-1]);
		}
	}

}

