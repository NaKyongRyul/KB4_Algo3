package Day8.B2178_미로탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B2178_미로탐색_전민형 {
	
	static int num;
	static int line;
	static int arr [][];
	static int dist [][];
	static int [] dx = {1,-1,0,0};
	static int [] dy = {0,0,1,-1};

	static class Maze {
		int x;
		int y;
		
		Maze(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		String com [] = str.split(" ");
		
		num = Integer.parseInt(com[0]);
		line = Integer.parseInt(com[1]);
		
		arr = new int [num][line];
		dist = new int [num][line];

		for(int i = 0; i<num; i++) {
			str = reader.readLine();
			com = str.split("");

			for(int j = 0; j<line; j++) {
				arr[i][j] = Integer.parseInt(com[j]);
			}
		}
		
		Maze maze = new Maze(0,0);
		dist[0][0] = 1;
		
		Queue <Maze> que = new LinkedList<>();
		
		maze.x = 0;
		maze.y = 0;
		
		que.add(maze);
		
		while(!que.isEmpty()) {
			Maze now = que.poll();
			
			for(int i = 0; i<4; i++) {
				int nextx = now.x +dx[i];
				int nexty = now.y +dy[i];
				
				if(nextx>=0 && nextx<num && nexty>=0 && nexty<line && dist[nextx][nexty]==0 && arr[nextx][nexty]==1) {
					que.add(new Maze(nextx, nexty));
					dist[nextx][nexty] = dist[now.x][now.y] + 1;
				}
			}
		}
		
		System.out.println(dist[num-1][line-1]);
	}

}
