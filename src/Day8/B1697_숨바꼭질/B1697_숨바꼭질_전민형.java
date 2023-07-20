package Day8.B1697_숨바꼭질;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class B1697_숨바꼭질_전민형 {
	
	static int sub;
	static int dong;
	static int [] dist;
	static int max = 100001;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		String com [] = str.split(" ");
		
		sub = Integer.parseInt(com[0]);
		dong = Integer.parseInt(com[1]);
		
		dist = new int [max];
		Queue <Integer> que = new ArrayDeque<>();
		
		
		que.add(sub);
		dist[sub] = 0;


		while(!que.isEmpty()) {
			
			int next = que.poll();
			if(next == dong) break;

			if((next+1)>=0 && (next+1)<max && dist[next+1]==0) {
				que.add(next+1);
				dist[next+1] = dist[next]+1;
			}

			if((next-1)>=0 && (next-1)<max && dist[next-1]==0) {
				que.add(next-1);
				dist[next-1] = dist[next]+1;
			}

			if((next*2)>=0 && (next*2)<max && dist[next*2]==0) {
				que.add(next*2);
				dist[next*2] = dist[next]+1;
			}


		}
		
		System.out.println(dist[dong]);

		
	}

}