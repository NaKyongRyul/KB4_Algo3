import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2178_미로탐색_황지현 {
	static int [][]arr;
	static int N;
	static int M;
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	static int cnt=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String [] str=br.readLine().split(" ");
		N=Integer.parseInt(str[0]);
		M=Integer.parseInt(str[1]);
		//이중리스트
		arr=new int[N][M];
		
//		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0; i<N;i++) {
			String [] str2=br.readLine().split("");
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(str2[j]);
			}
			
		}
		
		BFS(0,0);
	}
	
	public static void BFS(int x, int y) {
		Queue <Point>queue=new LinkedList<>();
		queue.add(new Point(x,y));
	
		while(!queue.isEmpty()) {
			Point p=queue.poll();
			int cur_x=p.x;
			int cur_y=p.y;
			for (int i=0;i<4;i++) {
				int next_x=cur_x+dx[i];
				int next_y=cur_y+dy[i];
				if (next_x<0 || next_y<0|| next_x>=N || next_y>=M ) {
					continue;
				}
				if(arr[next_x][next_y]==0) continue;
				
				if(arr[next_x][next_y]==1) {
					arr[next_x][next_y]=arr[cur_x][cur_y]+1;
				
					queue.add(new Point(next_x,next_y));
					
				}
				
				
			}
		}
		System.out.println(arr[N-1][M-1]);
	}
	
}
