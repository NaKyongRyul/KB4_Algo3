package Day1.B11660_구간합구하기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B11660_구간합구하기2_김태환 {

//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int N=sc.nextInt();
//		int M=sc.nextInt();
//		
//		int [][] arr=new int[N][N];
//		int [] answerarr=new int[M];
//		
//	    int[][] sum = new int[N][N];
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<N;j++) {
//				arr[i][j]=sc.nextInt();
//			}
//		}
//		
//	    for (int i = 0; i < N; i++) {
//	        for (int j = 0; j < N; j++) {
//	            sum[i][j] = arr[i][j];
//	            if (i > 0) sum[i][j] += sum[i-1][j]; // 위쪽 누적합
//	            if (j > 0) sum[i][j] += sum[i][j-1]; // 왼쪽 누적합
//	            if (i > 0 && j > 0) sum[i][j] -= sum[i-1][j-1]; // 중복 제거
//	        }
//	    }
//
//		for(int i=0;i<M;i++) {
//			int answer=0;
//			int x1=sc.nextInt();
//			int y1=sc.nextInt();
//			int x2=sc.nextInt();
//			int y2=sc.nextInt();
//			for(int j=x1;j<=x2;j++) {
//				for(int k=y1;k<=y2;k++) {
//					answer+=arr[j-1][k-1];
//					
//				}
//			}
//		answerarr[i]=answer;
//		}
//		for(int i=0;i<M;i++) {
//		System.out.println(answerarr[i]);
//		}
//	
//
//	}
//}

//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int N=sc.nextInt();
//		int M=sc.nextInt();
//		
//		int [][] arr=new int[N][N];
//		int [] answerarr=new int[M];
//		
//	    int[][] sum = new int[N][N];
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<N;j++) {
//				arr[i][j]=sc.nextInt();
//			}
//		}
//	}
	
//	public static void main(String[] args) throws IOException{
//		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
//		
//		StringTokenizer token = new StringTokenizer(bf.readLine()," "); //next Token이라는 걸로 불러올 수 있음
////		bf.readLine(); // 그냥 불러오면 4 3 불러와짐 , 그래서 StringTokenizer
//	    
//		int N= Integer.parseInt(token.nextToken());
//		int M= Integer.parseInt(token.nextToken());
//		
//		int [][] arr= new int[N+1][N+1];
//		
//		for(int i=0;i<N+1;i++) {
//			token = new StringTokenizer(bf.readLine()," ");
//			for(int j=0;j<N+1;j++) arr[i][j] = Integer.parseInt(token.nextToken());
//		}
//		
//		
//		int[][] dp=new int[N+1][N+1];
//		
//		for(int x=1;x<N+1;x++) {
//			for(int y=1;y<N+1;y++) 
//				dp[x][y]=dp[x][y-1]+dp[x-1][y]-dp[x-1][y-1]+arr[x][y];
//				
//			}
//			
//		for(int i=0;i<M;i++) {
//			token = new StringTokenizer(bf.readLine()," ");
//			int x1 = Integer.parseInt(token.nextToken());
//			int y1 = Integer.parseInt(token.nextToken());
//			int x2 = Integer.parseInt(token.nextToken());
//			int y2 = Integer.parseInt(token.nextToken());
//			
//			int tot=dp[x2][y2]-dp[x2][y1-1]-dp[x1-1][y2]+dp[x1-1][y1-1];
//			System.out.println(tot);
//		}
////		System.out.println(Arrays.deepToString(dp));
//			
//		}
//
//
//	}


public static void main(String[] args) throws IOException {
	
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer token = new StringTokenizer(bf.readLine() , " ");
	
	int N = Integer.parseInt(token.nextToken());
	int M = Integer.parseInt(token.nextToken());
	
	int [][] arr = new int[N+1][N+1];
	
	for(int i=1; i<N+1; i++) {
		token = new StringTokenizer(bf.readLine(), " ");
		for(int j=1; j<N+1; j++) arr[i][j] = Integer.parseInt(token.nextToken());
	}
	
	int [][] dp = new int [N+1][N+1];
	
	for(int x=1; x<N+1; x++) {
		for(int y=1; y <N+1; y++)
			dp[x][y] = dp[x][y-1] + dp[x-1][y] - dp[x-1][y-1] + arr[x][y];
	}
	
	for(int i=0; i<M; i++) {
		token = new StringTokenizer(bf.readLine(), " ");
		int x1 = Integer.parseInt(token.nextToken());
		int y1 = Integer.parseInt(token.nextToken());
		int x2 = Integer.parseInt(token.nextToken());
		int y2 = Integer.parseInt(token.nextToken());
		
		int tot = dp[x2][y2] - dp[x2][y1-1] 
					- dp[x1-1][y2] + dp[x1-1][y1-1];
		
		System.out.println(tot);
	}
}
}

