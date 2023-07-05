package Day1.B11660_구간합구하기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class B11660_구간합구하기2_서지수 {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		int[][] arr=new int[N+1][N+1];
		int[][] sumArr=new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				sumArr[i][j]=-sumArr[i-1][j-1]+sumArr[i][j-1]+sumArr[i-1][j]+arr[i][j];
			}
		}		

		for(int k=0;k<M;k++) {
			st = new StringTokenizer(bf.readLine());
			int sum=0;
			int x1=Integer.parseInt(st.nextToken());
			int y1=Integer.parseInt(st.nextToken());
			int x2=Integer.parseInt(st.nextToken());
			int y2=Integer.parseInt(st.nextToken());
			
			sum=sumArr[x2][y2]+sumArr[x1-1][y1-1]-sumArr[x2][y1-1]-sumArr[x1-1][y2];
			System.out.println(sum);
		}
	}

}
