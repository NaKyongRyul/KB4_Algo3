package Day1.B11660_구간합구하기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11660_구간합구하기2_전상희 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(bf.readLine(), " ");
		
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());

		int[][] arr = new int[N][N];
		int[][] sArr = new int[N+1][N+1];
		
		for(int i=0; i<N; i++) {
			token = new StringTokenizer(bf.readLine(), " ");
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(token.nextToken());			
			}			
		}
		
		for(int i=0; i<N; i++) {
			sArr[i+1][1] = sArr[i][1] + arr[i][0];
			sArr[1][i+1] = sArr[1][i] + arr[0][i];
		}
		
		for(int i=2; i<N+1; i++) {
			for(int j=2; j<N+1; j++) {
				sArr[i][j] = sArr[i-1][j] + sArr[i][j-1] - sArr[i-1][j-1] + arr[i-1][j-1];
			}			
		}
		
		System.out.println(Arrays.deepToString(sArr));
		
		int[] ans = new int[M];
		
		for(int i=0; i<M; i++) {
			token = new StringTokenizer(bf.readLine(), " ");
			int x1 = Integer.parseInt(token.nextToken());
			int y1 = Integer.parseInt(token.nextToken());
			int x2 = Integer.parseInt(token.nextToken());
			int y2 = Integer.parseInt(token.nextToken());
			ans[i] = sArr[x2][y2] -sArr[x1-1][y2] - sArr[x2][y1-1] + sArr[x1-1][y1-1];	
		}
		
		for(int a : ans) {
			System.out.println(a);
		}	
	}
}
