package Day1.B11660_구간합구하기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11660_구간합구하기5_박상희 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer token = new StringTokenizer(bf.readLine(), " ");
		
		int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        
        int table[][] = new int[N + 1][N + 1];
        int sum[][] = new int[N + 1][N + 1];
		
		for (int r = 1; r < N + 1; r++) {
			token = new StringTokenizer(bf.readLine(), " ");
			
			for (int c = 1; c < N + 1; c++) {
				table[r][c] = Integer.parseInt(token.nextToken());
				sum[r][c] = sum[r - 1][c] + sum[r][c - 1] + table[r][c] - sum[r - 1][c - 1];
			}
		}
		
		for (int i = 0; i < M; i++) {
			token = new StringTokenizer(bf.readLine(), " ");
			
			int x1 = Integer.parseInt(token.nextToken());
			int y1 = Integer.parseInt(token.nextToken());
			int x2 = Integer.parseInt(token.nextToken());
			int y2 = Integer.parseInt(token.nextToken());
			
			int result = sum[x2][y2] - sum[x2][y1 - 1] - sum[x1 - 1][y2] + sum[x1 - 1][y1 - 1];
			
			System.out.println(result);
		}
	}
}
